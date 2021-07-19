package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.dummy.presenter.model.PaymentElectricityRequest;
import com.jalin.resourceserver.module.dummy.presenter.model.PaymentMobilePhoneCreditRequest;
import com.jalin.resourceserver.module.dummy.presenter.model.PaymentMobilePhoneDataRequest;
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

    @PostMapping("/payment/mobile/prepaid/credit")
    public ResponseEntity<Object> payMobilePhoneCredit(@Valid @RequestBody PaymentMobilePhoneCreditRequest requestBody) {
        TransactionDto transactionDto = paymentService.payMobilePhoneCredit(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getMobilePhoneNumber(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Payment successful", transactionDto),
                HttpStatus.CREATED);
    }
    
    @PostMapping("/payment/mobile/prepaid/data")
    public ResponseEntity<Object> payMobilePhoneData(@Valid @RequestBody PaymentMobilePhoneDataRequest requestBody) {
        TransactionDto transactionDto = paymentService.payMobilePhoneData(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getMobilePhoneNumber(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Payment successful", transactionDto),
                HttpStatus.CREATED);
    }

    @PostMapping("/payment/electricity/prepaid")
    public ResponseEntity<Object> payElectricityPrepaid(@Valid @RequestBody PaymentElectricityRequest requestBody) {
        TransactionDto transactionDto = paymentService.payElectricityPrepaid(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getCustomerId(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Payment successful", transactionDto),
                HttpStatus.CREATED);
    }

    @PostMapping("/payment/electricity/postpaid")
    public ResponseEntity<Object> payElectricityPostpaid(@Valid @RequestBody PaymentElectricityRequest requestBody) {
        TransactionDto transactionDto = paymentService.payElectricityPostpaid(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getCustomerId(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Payment successful", transactionDto),
                HttpStatus.CREATED);
    }
}
