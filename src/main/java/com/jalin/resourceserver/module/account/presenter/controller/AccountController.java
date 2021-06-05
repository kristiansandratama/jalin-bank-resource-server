package com.jalin.resourceserver.module.account.presenter.controller;

import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.presenter.request.AddNewAccountRequest;
import com.jalin.resourceserver.module.account.presenter.response.AddNewAccountResponse;
import com.jalin.resourceserver.module.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/banking/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Object> addNewAccount(@Valid @RequestBody AddNewAccountRequest requestBody) {
        accountService.addNewAccount(new Account(requestBody.getCurrency(), requestBody.getBalance()));
        return new ResponseEntity<>(
                new AddNewAccountResponse(true, "New banking account successfully added"),
                HttpStatus.CREATED);
    }
}
