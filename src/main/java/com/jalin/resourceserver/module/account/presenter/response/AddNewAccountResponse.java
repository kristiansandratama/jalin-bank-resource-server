package com.jalin.resourceserver.module.account.presenter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddNewAccountResponse {
    private Boolean success;
    private String message;
}
