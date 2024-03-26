package com.example.Project06.Dto;

import com.example.Project06.Dto.TpoDto.TpoDto;
import lombok.Data;

import java.util.List;

@Data
public class TpoStudentDataResponseDto {
    private String message;
    private Object object;
    private String exception;


    public TpoStudentDataResponseDto(String message) {
        this.message = message;
    }
}
