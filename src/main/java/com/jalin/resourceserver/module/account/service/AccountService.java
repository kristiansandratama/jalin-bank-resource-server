package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.entity.Account;

import java.util.UUID;

public interface AccountService {
    void addNewAccount(UUID customerId, Account requestBody);
}
