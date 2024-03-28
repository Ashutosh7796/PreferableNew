package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ExamAnsDto;
import com.example.Project06.Entity.ExamAns;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.ExamAnsRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.ExamAnsService;
import com.example.Project06.exception.ExamAnsNotFoundException;
import com.example.Project06.exception.ExamAnsnotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamAnsServiceImpl implements ExamAnsService {

    @Autowired
  ExamAnsRepo examAnsRepo;

    @Autowired
    UserRepository userRepository;

    @Override
    public String addExamAns(ExamAnsDto examAnsDto) {
        ExamAns examAns=new ExamAns(examAnsDto);
        examAnsRepo.save(examAns);
        return "ExamAns Added";
    }


    @Override
    public List<ExamAns> gellAllExamAns() {


        return examAnsRepo.findAll();
    }

    @Override
    public ExamAnsDto getExamAnsById(Integer examAnsById) {
       Optional<ExamAns>byId=this.examAnsRepo.findById(examAnsById);
       if(byId.isPresent()){
           ExamAns examAns=byId.get();
           ExamAnsDto examAnsDto=new ExamAnsDto();
           return new ExamAnsDto(examAns);
       }else{
           throw new ExamAnsnotFoundByIdException("ExamAns Not Found");
       }
    }

    @Override
    public String deleteExamAns(Integer examAnsId) {
        Optional<ExamAns>byId=this.examAnsRepo.findById(examAnsId);
        if(byId.isPresent()){
            examAnsRepo.deleteById(examAnsId);
            return "ExamAns Deleted Successfuilly";
        }else {
            throw new ExamAnsnotFoundByIdException("ExamAns Not Found");
        }
    }


    @Override
    public ExamAns updateExamAns(ExamAnsDto examAnsDto, Integer examAnsId) {
        Optional<ExamAns> optionalExamAns = examAnsRepo.findById(examAnsId);
        if (optionalExamAns.isPresent()) {
            ExamAns examAns = optionalExamAns.get();

            examAns.setQ(examAnsDto.getQ());
            examAns.setAns(examAnsDto.getAns());
            examAns.setUserId(examAnsDto.getUserId());
            examAns.setSeatNo(examAnsDto.getSeatNo());
            examAns.setSub(examAnsDto.getSub());
            examAns.setDate(examAnsDto.getDate());
            examAns.setExamAnscol(examAnsDto.getExamAnscol());

            return examAnsRepo.save(examAns);
        } else {
            throw new ExamAnsnotFoundByIdException("ExamAns Not Found");
        }
    }



}
