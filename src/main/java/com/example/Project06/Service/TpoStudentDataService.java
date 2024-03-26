package com.example.Project06.Service;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Dto.TpoStudentDataDto;
import com.example.Project06.Entity.TpoStudentData;

import java.util.List;

public interface TpoStudentDataService {
    String addTpoStudentData(TpoStudentDataDto tpoStudentDataDto, Integer userId);
    TpoStudentDataDto getByTpoStudentDataById(Integer tpoStudentData/*, Integer userId*/);

    List<TpoStudentDataDto> getAllTpoStudentData();

    public String deleteById(Integer tpoStudentData);

   public String updateTpoStudentData(TpoStudentDataDto tpoStudentDataDto, Integer tpoStudentData);

    List<TpoStudentDataDto> getByUserId(Integer userId);




}
