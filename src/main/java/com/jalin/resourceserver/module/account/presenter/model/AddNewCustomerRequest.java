package com.jalin.resourceserver.module.account.presenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddNewCustomerRequest {
    @NotBlank
    private String idCardNumber;
    @NotBlank
    private String fullName;
}
