package com.example.BTL.exception;

import com.example.BTL.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JwtAuthenticationFilterException.class)
    public ResponseEntity<AuthenticationResponse> handleExceptionJwtAuthFilter(){
        return ResponseEntity.badRequest().body(AuthenticationResponse.builder().message("Token invalid").build());
    }
}
