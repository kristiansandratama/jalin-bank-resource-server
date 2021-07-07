package com.jalin.resourceserver.module.dummy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProviderDto {
    private String providerId;
    private String prefixNumber;
    private String productName;
    private String providerName;
}
