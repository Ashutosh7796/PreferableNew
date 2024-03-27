package com.example.Project06.Dto.JobScreenAns;


import lombok.Data;



@Data
public class ResponseAllJobScreenAnsDto {

    private String message;
    private java.util.List<JobScreenAnsDto> List;

    public ResponseAllJobScreenAnsDto(String message)
    {
        this.message = message;
    }


}
