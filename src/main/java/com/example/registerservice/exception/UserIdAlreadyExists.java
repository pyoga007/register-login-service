package com.example.registerservice.exception;

public class UserIdAlreadyExists extends RuntimeException{
    private String message;
    public UserIdAlreadyExists(String message){
        super(message);
    }
}
