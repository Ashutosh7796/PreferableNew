package com.example.Project06.Controller;

import com.example.Project06.Dto.JobScreenAns.JobScreenAnsDto;
import com.example.Project06.Dto.JobScreenAns.ResponseAllJobScreenAnsDto;
import com.example.Project06.Dto.JobScreenAns.ResponseSingleJobScreenAnsDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.JobScreenAnsService;
import com.example.Project06.exception.JobScreenAnsNotFoundException;
import com.example.Project06.exception.LiveProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobscreenans")
public class JobScreenAnsController {


    private final JobScreenAnsService jobScreenAnsService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> JobScreenAnsAdd(@RequestBody JobScreenAnsDto jobScreenAnsDto)
    {
        try {
            String result = jobScreenAnsService.AddJobScreenAns(jobScreenAnsDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",result)));
        }catch (LiveProjectNotFoundException liveProjectNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","Job Ans Screen not found")));
        }
    }

    @GetMapping("/id")
    public ResponseEntity<ResponseSingleJobScreenAnsDto> JobScreenAnsById(@RequestParam Integer jobscreenAnsId)
    {
        try {
            ResponseSingleJobScreenAnsDto responseSingleJobScreenAnsDto =new ResponseSingleJobScreenAnsDto("Success");
            JobScreenAnsDto jobscreenans = jobScreenAnsService.GetById(jobscreenAnsId);
            responseSingleJobScreenAnsDto.setObject(jobscreenans);
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleJobScreenAnsDto);

        }catch (JobScreenAnsNotFoundException jobScreenAnsNotFoundException)
        {
            ResponseSingleJobScreenAnsDto responseSingleJobScreenAnsDto =new ResponseSingleJobScreenAnsDto("unsuccess");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleJobScreenAnsDto);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllJobScreenAnsDto> getAllJobScreenAns()
    {
        try {
            ResponseAllJobScreenAnsDto responseAllJobScreenAnsDto = new ResponseAllJobScreenAnsDto("success");
            List<JobScreenAnsDto> jobscreenans = jobScreenAnsService.GetAllJobScreenAns();
            responseAllJobScreenAnsDto.setList(jobscreenans);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllJobScreenAnsDto);
        }catch (JobScreenAnsNotFoundException jobScreenAnsNotFoundException)
        {
            ResponseAllJobScreenAnsDto responseAllJobScreenAnsDto =new ResponseAllJobScreenAnsDto("unsuccessful");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllJobScreenAnsDto);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteJobScreenAns(@RequestParam Integer jobscreenAnsId)
    {
        try {
            String result = jobScreenAnsService.deleteJobScreenAns(jobscreenAnsId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (JobScreenAnsNotFoundException jobScreenAnsNotFoundException)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces", "Job Screen Ans  not found"));
        }
    }


    @PatchMapping("/update/{jobscreenAnsId}")

    public ResponseEntity<ResponseDto> updateJobScreenAns(@RequestBody JobScreenAnsDto jobScreenAnsDto, @PathVariable Integer jobscreenAnsId)
    {


        try {
            String result = jobScreenAnsService.updateJobScreenAns(jobScreenAnsDto, jobscreenAnsId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (JobScreenAnsNotFoundException jobScreenAnsNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));


        }


    }



}
