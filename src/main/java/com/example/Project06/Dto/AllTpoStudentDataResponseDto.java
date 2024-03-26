package com.example.Project06.Dto;

import lombok.Data;

import java.util.List;
@Data
public class AllTpoStudentDataResponseDto {
    private String message;
    private List<TpoStudentDataDto> list;
    private String exception;

    public AllTpoStudentDataResponseDto(String message) {
        this.message = message;
    }

}
