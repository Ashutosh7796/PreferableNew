package com.example.Project06.Entity;

import com.example.Project06.Dto.ExamAnsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "ExamAnses")
@Getter
@Setter
@NoArgsConstructor
public class ExamAns {

    @Id
    @Column(nullable = false ,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examAns;

    @Column(length = 250)
    private String q;

    @Column(length = 45)
    private String ans;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String seatNo;

    @Column(length = 45)
    private String sub;

    @Column
    private OffsetDateTime date;

    @Column(length = 45)
    private String examAnscol;


    public ExamAns(ExamAnsDto examAnsDto){
        this.examAns=examAnsDto.getExamAns();
        this.q=examAnsDto.getQ();
        this.ans=examAnsDto.getAns();
        this.userId=examAnsDto.getUserId();
        this.seatNo=examAnsDto.getSeatNo();
        this.sub=examAnsDto.getSub();
        this.date=examAnsDto.getDate();
        this.examAnscol=examAnsDto.getExamAnscol();

    }


}