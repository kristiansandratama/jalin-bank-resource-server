package com.jalin.resourceserver.module.account.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.model.AccountDto;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.account.presenter.model.AddNewAccountRequest;
import com.jalin.resourceserver.module.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Object> addNewAccount(
            @RequestParam UUID customerId,
            @Valid @RequestBody AddNewAccountRequest requestBody) {
        AccountDto newAccount = accountService.addNewAccount(customerId, new Account(requestBody.getCurrency(), requestBody.getBalance()));
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "New bank account successfully added", newAccount),
                HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<Object> getAccountByAccountNumber(@PathVariable String accountNumber) {
        AccountDto accountDto = accountService.getAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Bank account successfully found", accountDto),
                HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountNumber}/transactions")
    public ResponseEntity<Object> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
        Set<TransactionDto> transactionDtoSet = accountService.getTransactionsByAccountNumber(accountNumber);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Transactions successfully found", transactionDtoSet),
                HttpStatus.OK);
    }
}
