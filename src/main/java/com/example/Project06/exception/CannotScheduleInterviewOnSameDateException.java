package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class CannotScheduleInterviewOnSameDateException extends RuntimeException {

    private HttpStatus httpStatus;
    public CannotScheduleInterviewOnSameDateException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
