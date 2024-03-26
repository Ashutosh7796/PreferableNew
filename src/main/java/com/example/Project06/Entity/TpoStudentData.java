package com.example.Project06.Entity;

import com.example.Project06.Dto.TpoStudentDataDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "TpoStudentDatas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpoStudentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer tpoStudentData;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String testName;

    @Column(length = 45)
    private String totalMarks;

    @Column(length = 45)
    private String marks;

    @Column(length = 45)
    private String result;

    @Column(length = 45)
    private String tpoStudentDatacol;



    public TpoStudentData(TpoStudentDataDto tpoStudentDataDto) {
        this.tpoStudentData = tpoStudentDataDto.getTpoStudentData();
        this.testName = tpoStudentDataDto.getTestName();
        this.totalMarks =tpoStudentDataDto.getTotalMarks();
        this.marks = tpoStudentDataDto.getMarks();
        this.result = tpoStudentDataDto.getResult();
        this.tpoStudentDatacol  = tpoStudentDataDto.getTpoStudentDatacol();
        this.userId = tpoStudentDataDto.getUserId();

    }
//
//    public Integer getTpoStudentData() {
//        return tpoStudentData;
//    }
//
//    public void setTpoStudentData(Integer tpoStudentData) {
//        this.tpoStudentData = tpoStudentData;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getTestName() {
//        return testName;
//    }
//
//    public void setTestName(String testName) {
//        this.testName = testName;
//    }
//
//    public String getTotalMarks() {
//        return totalMarks;
//    }
//
//    public void setTotalMarks(String totalMarks) {
//        this.totalMarks = totalMarks;
//    }
//
//    public String getMarks() {
//        return marks;
//    }
//
//    public void setMarks(String marks) {
//        this.marks = marks;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
//
//    public String getTpoStudentDatacol() {
//        return tpoStudentDatacol;
//    }
//
//    public void setTpoStudentDatacol(String tpoStudentDatacol) {
//        this.tpoStudentDatacol = tpoStudentDatacol;
//    }
}


