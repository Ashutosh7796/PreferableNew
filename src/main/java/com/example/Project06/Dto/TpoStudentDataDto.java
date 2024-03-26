package com.example.Project06.Dto;

import com.example.Project06.Entity.TpoStudentData;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TpoStudentDataDto {
    private Integer tpoStudentData;
    private String testName;
    private String totalMarks;
    private String marks;
    private String result;
    private String tpoStudentDatacol;
    private Integer userId;

    public TpoStudentDataDto(TpoStudentData tpoStudentData){
        this.tpoStudentData = tpoStudentData.getTpoStudentData();
        this.testName = tpoStudentData.getTestName();
        this.marks = tpoStudentData.getMarks();
        this.totalMarks = tpoStudentData.getTotalMarks();
        this.result = tpoStudentData.getResult();
        this.tpoStudentDatacol = tpoStudentData.getTpoStudentDatacol();
        this.userId = tpoStudentData.getUserId();

   }


    public TpoStudentDataDto(TpoStudentDataDto tpoStudentDataDto) {
    }
}
