package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.model.CustomerDto;
import com.jalin.resourceserver.module.account.repository.AccountRepository;
import com.jalin.resourceserver.module.account.repository.CustomerRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addNewCustomer(Customer requestBody) {
        Customer newCustomer = new Customer(
                requestBody.getFullName(),
                requestBody.getMobileNumber());
        customerRepository.save(newCustomer);
    }

    @Override
    public CustomerDto findByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Customer with mobile number %s not found", mobileNumber)));
        return modelMapperUtility.mapper().map(customer, CustomerDto.class);
    }
}
