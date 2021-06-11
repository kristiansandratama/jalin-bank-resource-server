package com.jalin.resourceserver.module.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private String transactionId;
    private String transactionDate;
    private String transactionType;
    private String currency;
    private BigDecimal amount;
    private String transactionName;
    private String transactionDescription;
}
