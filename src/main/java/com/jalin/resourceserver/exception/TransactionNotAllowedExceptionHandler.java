package com.jalin.resourceserver.exception;

import com.jalin.resourceserver.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionNotAllowedExceptionHandler {
    @ExceptionHandler(TransactionNotAllowedException.class)
    public ResponseEntity<Object> handleException(TransactionNotAllowedException exception) {
        return new ResponseEntity<>(
                new ErrorResponse(false, exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
