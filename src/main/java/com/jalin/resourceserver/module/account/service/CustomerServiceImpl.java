package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.model.CustomerDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.CustomerRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto addNewCustomer(Customer requestBody) {
        Customer newCustomer = new Customer(
                requestBody.getIdCardNumber(),
                requestBody.getFullName());

        CustomerDto newCustomerDto = modelMapperUtility.initialize()
                .map(customerRepository.save(newCustomer), CustomerDto.class);
        newCustomerDto.setAccounts(new HashSet<>());
        return newCustomerDto;
    }

    @Override
    public CustomerDto findCustomerByIdCardNumber(String idCardNumber) {
        Customer customer = customerRepository.findByIdCardNumber(idCardNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Customer with ID card number %s not found", idCardNumber)));
        return modelMapperUtility.initialize().map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto findCustomerByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with number %s not found", accountNumber)));
        return modelMapperUtility.initialize().map(account.getCustomer(), CustomerDto.class);
    }
}
