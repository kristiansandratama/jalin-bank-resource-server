package com.jalin.resourceserver.utility;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateGeneratorUtility {
    public LocalDate generateDate() {
        return LocalDate.now();
    }
}
