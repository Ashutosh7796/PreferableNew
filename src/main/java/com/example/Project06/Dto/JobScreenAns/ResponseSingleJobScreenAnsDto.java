package com.example.Project06.Dto.JobScreenAns;


import lombok.Data;

@Data
public class ResponseSingleJobScreenAnsDto {

    private String message;
    private Object object;

    public ResponseSingleJobScreenAnsDto(String message)
    {
        this.message = message;
    }


}
