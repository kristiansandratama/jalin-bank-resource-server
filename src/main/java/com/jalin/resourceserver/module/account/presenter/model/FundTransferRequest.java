package com.jalin.resourceserver.module.account.presenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FundTransferRequest {
    @NotBlank
    private String sourceAccountNumber;
    @NotBlank
    private String beneficiaryAccountNumber;
    @Positive
    private BigDecimal amount;
}
