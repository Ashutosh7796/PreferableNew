package com.example.Project06.Dto.JobScreenAns;

import com.example.Project06.Entity.JobScreenAns;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class JobScreenAnsDto {

    private Integer jobScreenAns;
    private String question;
    private String ans;

    private String type;

    private Integer userId;

    private Integer jobId;

    private String seatNo;

    public JobScreenAnsDto (JobScreenAns jobScreenAns)

    {
        this.jobScreenAns=jobScreenAns.getJobScreenAns();
        this.userId=jobScreenAns.getUserId();
        this.ans=jobScreenAns.getAns();
        this.jobId=jobScreenAns.getJobId();
        this.question=jobScreenAns.getQuestion();
        this.seatNo=jobScreenAns.getSeatNo();
        this.type=jobScreenAns.getType();


    }

}
