package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class TpoStudentDataAlreayExistsException extends RuntimeException{
    private HttpStatus httpStatus;

    public TpoStudentDataAlreayExistsException(String message) {
        super(message);
    }

    public TpoStudentDataAlreayExistsException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }}
