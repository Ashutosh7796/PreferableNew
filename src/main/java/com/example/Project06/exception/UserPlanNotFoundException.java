package com.example.Project06.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserPlanNotFoundException extends RuntimeException {
    public UserPlanNotFoundException(String message) {
        super(message);
    }

    public UserPlanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPlanNotFoundException(String message, HttpStatus httpStatus) {
        super(message);

    }
}
