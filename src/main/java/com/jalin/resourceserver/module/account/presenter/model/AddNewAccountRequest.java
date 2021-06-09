package com.jalin.resourceserver.module.account.presenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddNewAccountRequest {
    @NotBlank
    private String currency;
    @Min(value = 0)
    private BigDecimal balance;
}
