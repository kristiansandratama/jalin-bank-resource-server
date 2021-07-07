package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.dummy.presenter.model.PaymentQrRequest;
import com.jalin.resourceserver.module.dummy.service.PaymentService;
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
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/qr")
    public ResponseEntity<Object> payWithQr(@Valid @RequestBody PaymentQrRequest requestBody) {
        TransactionDto transactionDto = paymentService.payWithQr(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Payment successful", transactionDto),
                HttpStatus.CREATED);
    }
}