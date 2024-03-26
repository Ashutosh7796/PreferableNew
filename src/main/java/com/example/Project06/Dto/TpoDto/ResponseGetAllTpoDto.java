package com.example.Project06.Dto.TpoDto;

import com.example.Project06.Dto.TpoDto.TpoDto;
import lombok.Data;

import java.util.List;
@Data
public class ResponseGetAllTpoDto {
    private String message;
    private List<TpoDto> list;
    private String exception;

    public ResponseGetAllTpoDto(String message) {
        this.message = message;
    }

}
