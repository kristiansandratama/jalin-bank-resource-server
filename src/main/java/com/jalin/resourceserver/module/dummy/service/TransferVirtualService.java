package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.account.model.TransactionDto;

import java.math.BigDecimal;

public interface TransferVirtualService {
    TransactionDto transferVirtual(String sourceAccountNumber, String corporateId, String beneficiaryAccountNumber, BigDecimal amount);
}
