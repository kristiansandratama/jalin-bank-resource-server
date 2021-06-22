package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.exception.TransactionNotAllowedException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Transaction;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.account.model.TransferDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.TransactionRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferServiceImpl implements TransferService{
    private static final String JALIN_BANK_CODE = "212";
    private static final String JALIN_BANK_NAME = "Bank Jalin";
    private static final String CREDIT_TRANSACTION_TYPE = "C";
    private static final String DEBIT_TRANSACTION_TYPE = "D";
    private static final String IDR_CURRENCY = "IDR";
    private static final BigDecimal IDR_MIN_BALANCE = new BigDecimal("0");
    private static final String TRANSFER_TRANSACTION_NAME = "TRANSFER";
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransferDto fundTransfer(String sourceAccountNumber, String beneficiaryAccountNumber, BigDecimal amount) {
        if (sourceAccountNumber.equals(beneficiaryAccountNumber)) {
            throw new TransactionNotAllowedException(
                    "The beneficiary account number cannot be the same as the source account number");
        }

        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Account beneficiaryAccount = accountRepository.findById(beneficiaryAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", beneficiaryAccountNumber)));

        if (!matchCurrency(sourceAccount, beneficiaryAccount)) {
            throw new TransactionNotAllowedException("Currency does not match");
        } else if (!sourceAccount.getCurrency().equals(IDR_CURRENCY) || !beneficiaryAccount.getCurrency().equals(IDR_CURRENCY)) {
            throw new TransactionNotAllowedException("Fund transfers with foreign currency are currently not supported");
        } else if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        } else {
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
            beneficiaryAccount.setBalance(beneficiaryAccount.getBalance().add(amount));
            accountRepository.save(sourceAccount);
            accountRepository.save(beneficiaryAccount);

            Transaction sourceAccountNewTransaction = initializeTransaction(
                    CREDIT_TRANSACTION_TYPE,
                    sourceAccount.getCurrency(),
                    amount,
                    TRANSFER_TRANSACTION_NAME,
                    String.format(
                            "%s/%s/%s",
                            JALIN_BANK_CODE,
                            beneficiaryAccountNumber,
                            "Transfer to" + " " + JALIN_BANK_NAME + " " + beneficiaryAccountNumber),
                    sourceAccount
            );
            Transaction beneficiaryAccountNewTransaction = initializeTransaction(
                    DEBIT_TRANSACTION_TYPE,
                    beneficiaryAccount.getCurrency(),
                    amount,
                    TRANSFER_TRANSACTION_NAME,
                    String.format(
                            "%s/%s/%s",
                            JALIN_BANK_CODE,
                            sourceAccountNumber,
                            "Transfer from" + " " + JALIN_BANK_NAME + " " + sourceAccountNumber),
                    beneficiaryAccount
            );
            Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
            Transaction beneficiaryTransaction = transactionRepository.save(beneficiaryAccountNewTransaction);

            TransactionDto sourceTransactionDto = modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
            TransactionDto beneficiaryTransactionDto = modelMapperUtility.initialize().map(beneficiaryTransaction, TransactionDto.class);

            return new TransferDto(sourceTransactionDto, beneficiaryTransactionDto);
        }
    }

    private Boolean matchCurrency(Account sourceAccount, Account beneficiaryAccount) {
        return sourceAccount.getCurrency().equals(beneficiaryAccount.getCurrency());
    }

    private Transaction initializeTransaction(
            String transactionType,
            String currency,
            BigDecimal amount,
            String transactionName,
            String transactionDescription,
            Account account) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionType(transactionType);
        transaction.setCurrency(currency);
        transaction.setAmount(amount);
        transaction.setTransactionName(transactionName);
        transaction.setTransactionDescription(transactionDescription);
        transaction.setAccount(account);
        return transaction;
    }
}
