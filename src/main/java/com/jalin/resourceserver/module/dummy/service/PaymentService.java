package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.account.model.TransactionDto;

import java.math.BigDecimal;

public interface PaymentService {
    TransactionDto payWithQr(String sourceAccountNumber, String corporateId, BigDecimal amount);
}
