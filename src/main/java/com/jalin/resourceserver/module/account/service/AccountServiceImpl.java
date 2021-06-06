package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.model.AccountDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.CustomerRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addNewAccount(UUID customerId, Account requestBody) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Customer Id %s not found", customerId)));

        Account newAccount = new Account(
                requestBody.getCurrency(),
                requestBody.getBalance(),
                customer);
        accountRepository.save(newAccount);
    }

    @Override
    public AccountDto getByAccountNumber(String accountNumber) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with account number %s not found", accountNumber)));
        return modelMapperUtility.mapper().map(account, AccountDto.class);
    }
}
