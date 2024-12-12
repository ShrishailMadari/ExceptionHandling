package com.shyloostyle.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Handle input empty exceptions
    @ExceptionHandler(InputEmptyException.class)
    public ResponseEntity<ErrorResponse> handleEmptyInput(InputEmptyException inputEmptyException){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "input is empty",
                System.currentTimeMillis()) ;
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }



}
