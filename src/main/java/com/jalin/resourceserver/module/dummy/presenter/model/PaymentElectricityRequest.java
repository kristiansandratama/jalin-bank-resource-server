package com.jalin.resourceserver.module.dummy.presenter.model;

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
public class PaymentElectricityRequest {
    @NotBlank
    private String sourceAccountNumber;
    @NotBlank
    private String corporateId;
    @NotBlank
    private String customerId;
    @Positive
    private BigDecimal amount;
}
