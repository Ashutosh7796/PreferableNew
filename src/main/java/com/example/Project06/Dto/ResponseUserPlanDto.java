package com.example.Project06.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserPlanDto {
    public String status;
    public String message;

    public ResponseUserPlanDto(String status, String message) {
        this.status=status;
        this.message=message;
    }

    public ResponseUserPlanDto() {
    }
}
