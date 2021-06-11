package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.exception.TransactionNotAllowedException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Transaction;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.account.model.TransferDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.TransactionRepository;
import com.jalin.resourceserver.utility.DateGeneratorUtility;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService{
    private static final String JALIN_BANK_CODE = "212";
    private static final BigDecimal IDR_MIN_BALANCE = new BigDecimal("0");
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private DateGeneratorUtility dateGeneratorUtility;
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
        } else if (!sourceAccount.getCurrency().equals("IDR") || !beneficiaryAccount.getCurrency().equals("IDR")) {
            throw new TransactionNotAllowedException("Fund transfers with foreign currency are currently not supported");
        } else if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        } else {
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
            beneficiaryAccount.setBalance(beneficiaryAccount.getBalance().add(amount));
            accountRepository.save(sourceAccount);
            accountRepository.save(beneficiaryAccount);

            Transaction sourceAccountNewTransaction = generateTransaction(
                    "C",
                    sourceAccount.getCurrency(),
                    amount,
                    "TRANSFER",
                    String.format("%s/%s/%s", JALIN_BANK_CODE, beneficiaryAccountNumber, "Transfer to " + beneficiaryAccountNumber),
                    sourceAccount
            );
            Transaction beneficiaryAccountNewTransaction = generateTransaction(
                    "D",
                    beneficiaryAccount.getCurrency(),
                    amount,
                    "TRANSFER",
                    String.format("%s/%s/%s", JALIN_BANK_CODE, sourceAccountNumber, "Transfer from " + sourceAccountNumber),
                    beneficiaryAccount
            );
            Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
            Transaction beneficiaryTransaction = transactionRepository.save(beneficiaryAccountNewTransaction);

            TransactionDto sourceTransactionDto = modelMapperUtility.mapper().map(sourceTransaction, TransactionDto.class);
            TransactionDto beneficiaryTransactionDto = modelMapperUtility.mapper().map(beneficiaryTransaction, TransactionDto.class);

            return new TransferDto(sourceTransactionDto, beneficiaryTransactionDto);
        }
    }

    private Boolean matchCurrency(Account sourceAccount, Account beneficiaryAccount) {
        return sourceAccount.getCurrency().equals(beneficiaryAccount.getCurrency());
    }

    private Transaction generateTransaction(
            String transactionType,
            String currency,
            BigDecimal amount,
            String transactionName,
            String transactionDescription,
            Account account) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate( dateGeneratorUtility.generateDate());
        transaction.setTransactionType(transactionType);
        transaction.setCurrency(currency);
        transaction.setAmount(amount);
        transaction.setTransactionName(transactionName);
        transaction.setTransactionDescription(transactionDescription);
        transaction.setAccount(account);
        return transaction;
    }
}
