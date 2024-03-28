package com.example.Project06.Controller;


import com.example.Project06.Dto.ExamAnsDto;
import com.example.Project06.Dto.ResponseDto1;
import com.example.Project06.Entity.ExamAns;
import com.example.Project06.Service.ExamAnsService;
import com.example.Project06.exception.ExamAnsAlreadyExistException;
import com.example.Project06.exception.ExamAnsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examans")
public class ExamAnsController {

    @Autowired
    public ExamAnsService examAnsService;



    @PostMapping("/addexamans")
    public ResponseEntity<ResponseDto1>addExamAns(@RequestBody ExamAnsDto examAnsDto){
        try{
            String result=examAnsService.addExamAns(examAnsDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("Success",result));
        }catch (ExamAnsNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("Failure","ExamAns not Found"));
        }
    }



    @GetMapping("/all")
    public List<ExamAns>getAllExamAns(){

    return examAnsService.gellAllExamAns();
    }


    @GetMapping("/get/{examansId}")
    public ResponseEntity<Optional<Object>>showExamAns(@PathVariable("examansId")Integer examansId){
    try{
        Optional<Object>examansById=Optional.ofNullable(this.examAnsService.getExamAnsById(examansId));
        if(examansById.isPresent()){
            return ResponseEntity.ok(examansById);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
    }
    }


    @DeleteMapping("/delete/{examansId}")
    public ResponseEntity<String>deletedExamAns(@PathVariable("examansId") Integer examansId){
    try{
        this.examAnsService.deleteExamAns(examansId);
        return ResponseEntity.ok("ExamAns Deleted Successfully");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Deleted:"+e.getMessage());
    }
    }


    @PutMapping("/update/{examansId}")
    public ResponseEntity<String> updateExamAns(@RequestBody ExamAnsDto examAnsDto, @PathVariable("examansId") Integer examansId) {
        try {
            ExamAns updatedExamAns = this.examAnsService.updateExamAns(examAnsDto, examansId);
            if (updatedExamAns != null) {
                return ResponseEntity.ok("ExamAns updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ExamAns not found for ID: " + examansId);
            }
        } catch (ExamAnsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ExamAns not found for ID: " + examansId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update: " + e.getMessage());
        }
    }

}
