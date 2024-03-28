package com.example.Project06.Dto;
import com.example.Project06.Entity.ExamAns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamAnsDto {

    private Integer examAns;
    private String q;
    private String ans;
    private Integer userId;
    private String seatNo;
    private String sub;
    private OffsetDateTime date;
    private String examAnscol;



    public ExamAnsDto(ExamAns examAns){

        this.examAns=examAns.getExamAns();
        this.q=examAns.getQ();
        this.ans=examAns.getAns();
        this.userId=examAns.getUserId();
        this.seatNo=examAns.getSeatNo();
        this.sub=examAns.getSub();
        this.date=examAns.getDate();
        this.examAnscol = examAns.getExamAnscol();
    }

}
