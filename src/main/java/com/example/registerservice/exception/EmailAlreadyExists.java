package com.example.registerservice.exception;

public class EmailAlreadyExists extends RuntimeException{
    String message;
    public EmailAlreadyExists(String message){
        super(message);
    }
}
