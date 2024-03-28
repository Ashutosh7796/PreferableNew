package com.example.Project06.Entity;

import com.example.Project06.Dto.SelectQuestionAnsStatusDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectQuestionAnsStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selectQuestionAnsStatusId", nullable = false)
    private Integer selectedQuestionId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "ansStatus")
    private Boolean ansStatus;

    @Column(name = "dateAndTimeToStartExam")
    private LocalDateTime dateTimeExamStart;

    @Column(name = "dateAndTimeToEndExam")
    private LocalDateTime dateAndTimeToEndExam;


    public SelectQuestionAnsStatus(SelectQuestionAnsStatusDto selectQuestionAnsStatusDto) {
        this.selectedQuestionId = selectQuestionAnsStatusDto.getSelectedQuestionId();
        this.userId = selectQuestionAnsStatusDto.getUserId();
        this.subject = selectQuestionAnsStatusDto.getSubject();
        this.ansStatus = selectQuestionAnsStatusDto.getAnsStatus();
        this.dateTimeExamStart = selectQuestionAnsStatusDto.getDateTimeExamStart();
        this.dateAndTimeToEndExam = selectQuestionAnsStatusDto.getDateAndTimeToEndExam();

    }


}









