package com.jalin.resourceserver.module.account.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.model.SuccessResponse;
import com.jalin.resourceserver.module.account.entity.Customer;
import com.jalin.resourceserver.module.account.model.CustomerDto;
import com.jalin.resourceserver.module.account.presenter.model.AddNewCustomerRequest;
import com.jalin.resourceserver.module.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Object> addNewCustomer(@Valid @RequestBody AddNewCustomerRequest requestBody) {
        CustomerDto newCustomer = customerService.addNewCustomer(new Customer(requestBody.getIdCardNumber(), requestBody.getFullName()));
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "New customer successfully added", newCustomer),
                HttpStatus.CREATED);
    }

    @GetMapping("/customers/find")
    public ResponseEntity<Object> findCustomerByIdCardNumber(@RequestParam String idCardNumber) {
        CustomerDto customer = customerService.findCustomerByIdCardNumber(idCardNumber);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Customer successfully found", customer),
                HttpStatus.OK);
    }
}
