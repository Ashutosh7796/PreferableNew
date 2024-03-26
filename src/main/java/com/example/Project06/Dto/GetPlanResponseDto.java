package com.example.Project06.Dto;

import lombok.Data;

@Data
public class GetPlanResponseDto {


    private String message;
    private Object object;
    private String exception;


    public GetPlanResponseDto(String message) {
        this.message = message;
    }
}
