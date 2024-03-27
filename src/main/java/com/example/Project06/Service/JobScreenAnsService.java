package com.example.Project06.Service;

import com.example.Project06.Dto.JobScreenAns.JobScreenAnsDto;

import java.util.List;

public interface JobScreenAnsService {


    public String AddJobScreenAns(JobScreenAnsDto jobScreenAnsDto);

    public JobScreenAnsDto GetById(Integer jobscreenAnsId);

    public List<JobScreenAnsDto> GetAllJobScreenAns();




    public String deleteJobScreenAns(Integer jobscreenAnsId);


    String updateJobScreenAns( JobScreenAnsDto jobScreenAnsDto,Integer jobscreenAnsId);
}
