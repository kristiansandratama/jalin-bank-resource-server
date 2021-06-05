package com.jalin.resourceserver.module.account.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddNewAccountRequest {
    private String currency;
    private BigDecimal balance;
}
