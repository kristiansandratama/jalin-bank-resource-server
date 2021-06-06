package com.jalin.resourceserver.module.account.presenter.controller;

import com.jalin.resourceserver.model.SuccessResponse;
import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.presenter.model.AddNewCustomerRequest;
import com.jalin.resourceserver.module.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Object> addNewCustomer(@Valid @RequestBody AddNewCustomerRequest requestBody) {
        customerService.addNewCustomer(new Customer(requestBody.getFullName(), requestBody.getMobileNumber()));
        return new ResponseEntity<>(
                new SuccessResponse(true, "New customer successfully added"),
                HttpStatus.CREATED);
    }
}
