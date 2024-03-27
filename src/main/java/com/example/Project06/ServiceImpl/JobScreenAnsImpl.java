package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.JobScreenAns.JobScreenAnsDto;
import com.example.Project06.Entity.JobScreenAns;
import com.example.Project06.Repository.JobScreenAnsRepo;
import com.example.Project06.Service.JobScreenAnsService;
import com.example.Project06.exception.JobScreenAnsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class JobScreenAnsImpl implements JobScreenAnsService {

    private final JobScreenAnsRepo jobScreenAnsRepo;
    @Override
    public String AddJobScreenAns(JobScreenAnsDto jobScreenAnsDto)

    {

        JobScreenAns jobScreenAns = new JobScreenAns(jobScreenAnsDto);
        jobScreenAnsRepo.save(jobScreenAns);
        return "job screen ans added";


    }

    @Override
    public JobScreenAnsDto GetById(Integer jobscreenAnsId) {
        Optional<JobScreenAns> jobScreenAns= jobScreenAnsRepo.findById(jobscreenAnsId);
        if (jobScreenAns.isEmpty())
        {
            throw new JobScreenAnsNotFoundException("Job Screen Ans not found", HttpStatus.NOT_FOUND);
        }
        JobScreenAnsDto jobScreenAnsDto = new JobScreenAnsDto(jobScreenAns.get());
        jobScreenAnsDto.setJobScreenAns(jobscreenAnsId);
        return jobScreenAnsDto;
    }

    @Override
    public List<JobScreenAnsDto> GetAllJobScreenAns() {
        List<JobScreenAns> jobScreenAns = jobScreenAnsRepo.findAll();
        return jobScreenAns.stream()
                .map(JobScreenAnsDto::new)
                .collect(Collectors.toList());
    }


    @Override
    public String deleteJobScreenAns(Integer jobscreenAnsId) {

        JobScreenAnsDto exit = GetById(jobscreenAnsId);

        if(exit== null )
        {
            throw new JobScreenAnsNotFoundException("Job Screen Ans :"+jobscreenAnsId + "not found");
        }
        jobScreenAnsRepo.deleteById(jobscreenAnsId);
        return "job screen ans id:"+ jobscreenAnsId + "has been deleted successfully";

    }
    @Override
    public String updateJobScreenAns(JobScreenAnsDto jobScreenAnsDto, Integer jobscreenAnsId) {


        JobScreenAns jobScreenAns = jobScreenAnsRepo.findById(jobscreenAnsId).orElseThrow(() ->

                new JobScreenAnsNotFoundException("Not Found", HttpStatus.NOT_FOUND));

        if (jobScreenAnsDto.getAns() != null) {
            jobScreenAns.setAns(jobScreenAnsDto.getAns());
        }
        if (jobScreenAnsDto.getJobId() != null) {
            jobScreenAns.setJobId(jobScreenAnsDto.getJobId());
        }
        if (jobScreenAnsDto.getType() != null) {
            jobScreenAns.setType(jobScreenAnsDto.getType());
        }

        if (jobScreenAnsDto.getQuestion() != null) {
            jobScreenAns.setQuestion(jobScreenAnsDto.getQuestion());
        }
        if (jobScreenAnsDto.getUserId() != null) {
            jobScreenAns.setUserId(jobScreenAnsDto.getUserId());
        }

        if (jobScreenAnsDto.getSeatNo() != null) {
            jobScreenAns.setSeatNo(jobScreenAnsDto.getSeatNo());
        }

        jobScreenAnsRepo.save(jobScreenAns);

        return "Job Screen Ans Updated" + jobscreenAnsId;


    }

}
