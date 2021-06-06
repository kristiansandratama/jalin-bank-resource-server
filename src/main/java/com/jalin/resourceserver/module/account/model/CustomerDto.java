package com.jalin.resourceserver.module.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private String fullName;
    private String mobileNumber;
    private Set<AccountDto> accounts;
}
