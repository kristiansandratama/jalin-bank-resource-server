package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.exception.TransactionNotAllowedException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Transaction;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.TransactionRepository;
import com.jalin.resourceserver.module.dummy.entity.Corporate;
import com.jalin.resourceserver.module.dummy.repository.CorporateRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final String CREDIT_TRANSACTION_TYPE = "C";
    private static final BigDecimal IDR_MIN_BALANCE = new BigDecimal("10000");
    private static final String PAYMENT_QR_TRANSACTION_NAME = "PAYMENT_QR";
    private static final String PAYMENT_MOBILE_PHONE_CREDIT_TRANSACTION_NAME = "PAYMENT_MOBILE_PHONE_CREDIT";
    private static final String PAYMENT_MOBILE_PHONE_DATA_TRANSACTION_NAME = "PAYMENT_MOBILE_PHONE_DATA";
    private static final String PAYMENT_BILL_TRANSACTION_NAME = "PAYMENT_BILL";
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CorporateRepository corporateRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDto payWithQr(String sourceAccountNumber, String corporateId, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Corporate corporate = corporateRepository.findById(corporateId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Corporate with corporate ID %s not found", corporateId)));

        if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        Transaction sourceAccountNewTransaction = initializeTransaction(
                CREDIT_TRANSACTION_TYPE,
                sourceAccount.getCurrency(),
                amount,
                PAYMENT_QR_TRANSACTION_NAME,
                String.format(
                        "%s/%s/%s",
                        corporateId,
                        null,
                        "Pay to" + " " + corporate.getCorporateName()),
                sourceAccount
        );
        Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
        return modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
    }

    @Override
    public TransactionDto payMobilePhoneCredit(String sourceAccountNumber, String corporateId, String mobilePhoneNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Corporate corporate = corporateRepository.findById(corporateId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Corporate with corporate ID %s not found", corporateId)));

        if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        Transaction sourceAccountNewTransaction = initializeTransaction(
                CREDIT_TRANSACTION_TYPE,
                sourceAccount.getCurrency(),
                amount,
                PAYMENT_MOBILE_PHONE_CREDIT_TRANSACTION_NAME,
                String.format(
                        "%s/%s/%s",
                        corporateId,
                        mobilePhoneNumber,
                        "Pay mobile phone prepaid credit to" + " " + corporate.getCorporateName() + " " + mobilePhoneNumber),
                sourceAccount
        );
        Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
        return modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
    }

    @Override
    public TransactionDto payMobilePhoneData(String sourceAccountNumber, String corporateId, String mobilePhoneNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Corporate corporate = corporateRepository.findById(corporateId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Corporate with corporate ID %s not found", corporateId)));

        if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        Transaction sourceAccountNewTransaction = initializeTransaction(
                CREDIT_TRANSACTION_TYPE,
                sourceAccount.getCurrency(),
                amount,
                PAYMENT_MOBILE_PHONE_DATA_TRANSACTION_NAME,
                String.format(
                        "%s/%s/%s",
                        corporateId,
                        mobilePhoneNumber,
                        "Pay mobile phone prepaid data to" + " " + corporate.getCorporateName() + " " + mobilePhoneNumber),
                sourceAccount
        );
        Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
        return modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
    }

    @Override
    public TransactionDto payElectricityPrepaid(String sourceAccountNumber, String corporateId, String customerId, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Corporate corporate = corporateRepository.findById(corporateId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Corporate with corporate ID %s not found", corporateId)));

        if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        Transaction sourceAccountNewTransaction = initializeTransaction(
                CREDIT_TRANSACTION_TYPE,
                sourceAccount.getCurrency(),
                amount,
                PAYMENT_BILL_TRANSACTION_NAME,
                String.format(
                        "%s/%s/%s",
                        corporateId,
                        customerId,
                        "Pay electricity prepaid token to" + " " + corporate.getCorporateName() + " " + customerId),
                sourceAccount
        );
        Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
        return modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
    }

    @Override
    public TransactionDto payElectricityPostpaid(String sourceAccountNumber, String corporateId, String customerId, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Corporate corporate = corporateRepository.findById(corporateId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Corporate with corporate ID %s not found", corporateId)));

        if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new TransactionNotAllowedException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        Transaction sourceAccountNewTransaction = initializeTransaction(
                CREDIT_TRANSACTION_TYPE,
                sourceAccount.getCurrency(),
                amount,
                PAYMENT_BILL_TRANSACTION_NAME,
                String.format(
                        "%s/%s/%s",
                        corporateId,
                        customerId,
                        "Pay electricity postpaid bill to" + " " + corporate.getCorporateName() + " " + customerId),
                sourceAccount
        );
        Transaction sourceTransaction = transactionRepository.save(sourceAccountNewTransaction);
        return modelMapperUtility.initialize().map(sourceTransaction, TransactionDto.class);
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
