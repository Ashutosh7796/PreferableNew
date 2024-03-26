package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class TpoNotFoundException extends RuntimeException {
    public TpoNotFoundException(String message, HttpStatus notFound){
        super();
    }
}

