package com.reallogin.Reallogin.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reallogin.Reallogin.exception.MycustomeException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MycustomeException.class)
    public ResponseEntity<String> handleMyCustomException(MycustomeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Other exception handlers can be added here as needed.
}
