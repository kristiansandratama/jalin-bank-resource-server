package com.jalin.resourceserver.module.account.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.account.model.TransferDto;
import com.jalin.resourceserver.module.account.presenter.model.FundTransferRequest;
import com.jalin.resourceserver.module.account.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${url.map.api}/v1")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping("/transfers")
    public ResponseEntity<Object> fundTransfer(@Valid @RequestBody FundTransferRequest requestBody) {
        TransferDto transferDto = transferService.fundTransfer(
                requestBody.getSourceAccountNumber(),
                requestBody.getBeneficiaryAccountNumber(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Fund successfully transferred", transferDto),
                HttpStatus.CREATED);
    }
}
