package com.example.Project06.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FeedbackDto {

    private Integer FeedbackId;
    private LocalDateTime date;
    private String feedback;
    private int userId;



    public FeedbackDto(){

    }
}