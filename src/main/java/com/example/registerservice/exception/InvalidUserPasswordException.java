package com.example.registerservice.exception;

public class InvalidUserPasswordException extends RuntimeException{

    private String message;

    public InvalidUserPasswordException(String message){
        super(message);
    }
}
