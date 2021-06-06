package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.model.AccountDto;

import java.util.UUID;

public interface AccountService {
    void addNewAccount(UUID customerId, Account requestBody);
    AccountDto getByAccountNumber(String accountNumber);
}
