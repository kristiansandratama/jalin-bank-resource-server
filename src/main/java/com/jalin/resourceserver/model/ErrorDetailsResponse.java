package com.jalin.resourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetailsResponse {
    private Boolean success;
    private String message;
    private Object errors;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class ErrorDetails {
        private String fieldName;
        private String message;
    }
}
