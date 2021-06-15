package com.jalin.resourceserver.module.account.service;

import com.jalin.resourceserver.module.account.model.TransferDto;

import java.math.BigDecimal;

public interface TransferService {
    TransferDto fundTransfer(String sourceAccountNumber, String beneficiaryAccountNumber, BigDecimal amount);
}
