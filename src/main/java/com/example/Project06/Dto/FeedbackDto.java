package com.example.Project06.Dto;

import com.example.Project06.Entity.Feedback;
import com.example.Project06.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FeedbackDto {
    private Integer feedbackId;
    private LocalDateTime date;
    private String feedback;
    private int userId;


    public FeedbackDto() {

    }
}
