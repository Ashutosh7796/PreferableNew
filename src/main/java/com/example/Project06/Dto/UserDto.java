package com.example.Project06.Dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserDto {

    private Integer user_id;
    private String fullName;
    private String email;

    private String moNumber;
    private String password;

    private String resetPasswordToken;

    private String status;

    private LocalDate date;

    private String ref;

    private String gender;

}
