package com.example.Project06.Service;

import com.example.Project06.Dto.SelectQuestionAnsStatusDto;
import com.example.Project06.Entity.SelectQuestionAnsStatus;

import java.util.List;

public interface SelectQuestionAnsStatusService {


    public String addSelectQuestionAnsStatus(SelectQuestionAnsStatusDto selectQuestionAnsStatusDto);

     List<SelectQuestionAnsStatus> getAllSelectQuestionAnsStatus();

     SelectQuestionAnsStatusDto getSelectQuestionAnsStatusById(Integer selectQuestionAnsStatusById);


     public String deleteSelectQuestionAnsStatus(Integer selectedQuestionId);

     public SelectQuestionAnsStatus updateSelectQuestionAnsStatus(SelectQuestionAnsStatusDto selectQuestionAnsStatusDto,Integer selectedQuestionId);
}
