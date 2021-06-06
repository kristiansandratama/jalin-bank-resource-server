package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService{
    private static final BigDecimal IDR_MIN_BALANCE = new BigDecimal("50000");
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void fundTransfer(String sourceAccountNumber, String beneficiaryAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", sourceAccountNumber)));

        Account beneficiaryAccount = accountRepository.findById(beneficiaryAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", beneficiaryAccountNumber)));

        if (!matchCurrency(sourceAccount, beneficiaryAccount)) {
            throw new RuntimeException("Currency does not match");
        } else if (!sourceAccount.getCurrency().equals("IDR") || !beneficiaryAccount.getCurrency().equals("IDR")) {
            throw new RuntimeException("Fund transfers with foreign currency are currently not supported");
        } else if (sourceAccount.getBalance().subtract(amount).compareTo(IDR_MIN_BALANCE) < 0) {
            throw new RuntimeException("Insufficient balance");
        } else {
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
            beneficiaryAccount.setBalance(beneficiaryAccount.getBalance().add(amount));
            accountRepository.save(sourceAccount);
            accountRepository.save(beneficiaryAccount);
        }
    }

    private Boolean matchCurrency(Account sourceAccount, Account beneficiaryAccount) {
        return sourceAccount.getCurrency().equals(beneficiaryAccount.getCurrency());
    }
}
