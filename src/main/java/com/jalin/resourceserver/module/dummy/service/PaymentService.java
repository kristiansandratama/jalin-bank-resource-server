package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.account.model.TransactionDto;

import java.math.BigDecimal;

public interface PaymentService {
    TransactionDto payWithQr(String sourceAccountNumber, String corporateId, BigDecimal amount);
    TransactionDto payMobilePhoneCredit(String sourceAccountNumber, String corporateId, String mobilePhoneNumber, BigDecimal amount);
    TransactionDto payMobilePhoneData(String sourceAccountNumber, String corporateId, String mobilePhoneNumber, BigDecimal amount);
    TransactionDto payElectricityPrepaid(String sourceAccountNumber, String corporateId, String customerId, BigDecimal amount);
    TransactionDto payElectricityPostpaid(String sourceAccountNumber, String corporateId, String customerId, BigDecimal amount);
}
