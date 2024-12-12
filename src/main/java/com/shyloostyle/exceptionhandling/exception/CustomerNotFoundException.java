package com.shyloostyle.exceptionhandling.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
