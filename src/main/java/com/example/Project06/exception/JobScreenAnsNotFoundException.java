package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class JobScreenAnsNotFoundException extends RuntimeException
{

    private HttpStatus httpStatus;

    public JobScreenAnsNotFoundException (String message)
    {
        super(message);
    }

    public JobScreenAnsNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

}


