package com.example.Project06.Dto;


import com.example.Project06.Entity.SelectQuestionAnsStatus;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectQuestionAnsStatusDto {
    private Integer selectedQuestionId;
    private Integer userId;
    private String subject;
    private Boolean ansStatus;
    private LocalDateTime dateTimeExamStart;
    private LocalDateTime dateAndTimeToEndExam;



    public SelectQuestionAnsStatusDto(SelectQuestionAnsStatus selectQuestionAnsStatus){
              this.selectedQuestionId=selectQuestionAnsStatus.getSelectedQuestionId();
              this.userId=selectQuestionAnsStatus.getUserId();
              this.subject=selectQuestionAnsStatus.getSubject();
              this.ansStatus=selectQuestionAnsStatus.getAnsStatus();
              this.dateTimeExamStart=selectQuestionAnsStatus.getDateTimeExamStart();
              this.dateAndTimeToEndExam=selectQuestionAnsStatus.getDateAndTimeToEndExam();

    }


}
