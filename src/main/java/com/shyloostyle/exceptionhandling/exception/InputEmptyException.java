package com.shyloostyle.exceptionhandling.exception;

public class InputEmptyException extends RuntimeException {
    public InputEmptyException(String message){
        super(message);
    }
}
