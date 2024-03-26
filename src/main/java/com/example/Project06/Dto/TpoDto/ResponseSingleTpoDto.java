package com.example.Project06.Dto.TpoDto;

import lombok.Data;

@Data
 public class ResponseSingleTpoDto {
        private String message;
        private Object object;
        private String exception;

    public ResponseSingleTpoDto(String message)
    {
        this.message = message;
    }
}
