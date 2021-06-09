package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.model.CustomerDto;

public interface CustomerService {
    CustomerDto addNewCustomer(Customer requestBody);
    CustomerDto findCustomerByIdCardNumber(String idCardNumber);
}
