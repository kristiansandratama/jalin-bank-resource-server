package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addNewCustomer(Customer requestBody) {
        Customer newCustomer = new Customer(
                requestBody.getFullName(),
                requestBody.getMobileNumber());
        customerRepository.save(newCustomer);
    }
}
