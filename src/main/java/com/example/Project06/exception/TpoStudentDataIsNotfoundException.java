package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class TpoStudentDataIsNotfoundException extends RuntimeException {
    public TpoStudentDataIsNotfoundException(String message, HttpStatus notFound){

        super(message);
    }
}
