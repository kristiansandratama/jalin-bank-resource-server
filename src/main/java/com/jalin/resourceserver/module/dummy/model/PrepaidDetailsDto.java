package com.jalin.resourceserver.module.dummy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrepaidDetailsDto {
    private UUID prepaidId;
    private String prepaidType;
    private String prepaidName;
    private String prepaidDetails;
    private BigDecimal price;
}
