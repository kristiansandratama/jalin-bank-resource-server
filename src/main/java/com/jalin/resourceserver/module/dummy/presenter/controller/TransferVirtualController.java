package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.account.model.TransactionDto;
import com.jalin.resourceserver.module.dummy.presenter.model.FundTransferVirtualRequest;
import com.jalin.resourceserver.module.dummy.service.TransferVirtualService;
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
public class TransferVirtualController {
    @Autowired
    private TransferVirtualService transferVirtualService;

    @PostMapping("/transfers/virtual")
    public ResponseEntity<Object> fundTransferVirtual(@Valid @RequestBody FundTransferVirtualRequest requestBody) {
        TransactionDto transactionDto = transferVirtualService.transferVirtual(
                requestBody.getSourceAccountNumber(),
                requestBody.getCorporateId(),
                requestBody.getBeneficiaryAccountNumber(),
                requestBody.getAmount());
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Fund successfully transferred", transactionDto),
                HttpStatus.CREATED);
    }
}
