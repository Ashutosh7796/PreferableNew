package com.example.Project06.Controller;

import com.example.Project06.Dto.AssessmentExamQuestions.AssessmentExamQuestionsDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.TpoDto.ResponseGetAllTpoDto;
import com.example.Project06.Dto.TpoDto.ResponseSingleTpoDto;
import com.example.Project06.Dto.TpoDto.TpoDto;
import com.example.Project06.Entity.Tpo;
import com.example.Project06.Service.TpoService;
import com.example.Project06.exception.AssessmentExamQuestionsException;
import com.example.Project06.exception.TpoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Tpo")
@RestController
@RequiredArgsConstructor


public class TpoController {
    @Autowired
    private  TpoService tpoService;


    @GetMapping("/getTpo")
    public ResponseEntity<ResponseSingleTpoDto> findById(@RequestParam int tpoId) {
        try {
            ResponseSingleTpoDto responseSingleJobDto = new ResponseSingleTpoDto("success");
            TpoDto tpo = tpoService.getById(tpoId);
            responseSingleJobDto.setObject(tpo);
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleJobDto);
        } catch (TpoNotFoundException tpoNotFoundException) {
            ResponseSingleTpoDto responseSingleTpoDto = new ResponseSingleTpoDto("unsuccess");
            responseSingleTpoDto.setException("Job not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleTpoDto);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateTpo(@RequestBody TpoDto tpoDto, @RequestParam Integer tpoId) {
        try {
            String result = tpoService.updateTpo(tpoDto, tpoId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (TpoNotFoundException tpoNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Tpo not found"));
        }
    }
    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<ResponseDto> deleteTpo(@PathVariable Integer tpoId){
        try {
            String result = tpoService.deleteById(tpoId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (RuntimeException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unSuccess", "Degree not found"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<TpoDto>> showAllTpos() {
        try {
            List<TpoDto> tpos = this.tpoService.getAllTpo();
            return ResponseEntity.ok(tpos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/user/{userId}/tpos")
    public ResponseEntity<List<TpoDto>> getTpoByUserId(@PathVariable Integer userId){
        List<TpoDto> tpoByUser= this.tpoService.getByUserId(userId);
        return new ResponseEntity<List<TpoDto>>(tpoByUser, HttpStatus.OK);
    }



}
