package com.jalin.resourceserver.module.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private String transactionId;
    private LocalDate transactionDate;
    private String transactionType;
    private String currency;
    private BigDecimal amount;
    private String transactionName;
    private String transactionDescription;
}
