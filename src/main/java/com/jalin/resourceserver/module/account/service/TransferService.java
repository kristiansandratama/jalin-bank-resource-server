package com.jalin.resourceserver.module.account.service;

import java.math.BigDecimal;

public interface TransferService {
    void fundTransfer(String sourceAccountNumber, String beneficiaryAccountNumber, BigDecimal amount);
}
