package com.example.Project06.Service;

import com.example.Project06.Dto.ExamAnsDto;
import com.example.Project06.Entity.ExamAns;

import java.util.List;

public interface ExamAnsService {




    public String addExamAns(ExamAnsDto examAnsDto);

   List<ExamAns>gellAllExamAns();

   ExamAnsDto getExamAnsById(Integer examAnsById);

   public String deleteExamAns(Integer examAnsId);

  public ExamAns updateExamAns(ExamAnsDto examAnsDto,Integer examAnsId);


}
