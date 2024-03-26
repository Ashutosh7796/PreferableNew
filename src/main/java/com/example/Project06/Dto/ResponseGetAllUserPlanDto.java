package com.example.Project06.Dto;

import com.example.Project06.Dto.TpoDto.TpoDto;
import lombok.Data;

import java.util.List;
@Data
public class ResponseGetAllUserPlanDto {
    private String message;
    private List<UserPlanDto> list;
    private String exception;

    public ResponseGetAllUserPlanDto(String message) {
        this.message = message;
    }
}
