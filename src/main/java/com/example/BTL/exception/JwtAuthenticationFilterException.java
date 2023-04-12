package com.example.BTL.exception;

public class JwtAuthenticationFilterException extends RuntimeException{
    public JwtAuthenticationFilterException(String message){
        super(message);
    }
}
