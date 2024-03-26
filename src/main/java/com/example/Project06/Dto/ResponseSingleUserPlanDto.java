package com.example.Project06.Dto;

import lombok.Data;

@Data
public class ResponseSingleUserPlanDto {
    private String message;
    private Object object;
    private String exception;

    public ResponseSingleUserPlanDto(String message) {
        this.message = message;
    }
}
