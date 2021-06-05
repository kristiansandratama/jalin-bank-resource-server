package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addNewAccount(Account account) {
        Account newAccount = new Account(
                account.getCurrency(),
                account.getBalance());
        accountRepository.save(newAccount);
    }
}
