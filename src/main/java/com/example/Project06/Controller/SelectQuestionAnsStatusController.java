package com.example.Project06.Controller;


import com.example.Project06.Dto.ResponseDto1;
import com.example.Project06.Dto.SelectQuestionAnsStatusDto;
import com.example.Project06.Entity.SelectQuestionAnsStatus;
import com.example.Project06.Service.SelectQuestionAnsStatusService;
import com.example.Project06.exception.SelectQuestionAnsStatusNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/selectquestionansstatus")
public class SelectQuestionAnsStatusController {


    private final SelectQuestionAnsStatusService selectQuestionAnsStatusService;


   @PostMapping("/add")
   public ResponseEntity<ResponseDto1> selectQuestionAnsStatusAdd(@RequestBody SelectQuestionAnsStatusDto selectQuestionAnsStatusDto) {
       try {
           String result = selectQuestionAnsStatusService.addSelectQuestionAnsStatus(selectQuestionAnsStatusDto);
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("Success", result));
       } catch (SelectQuestionAnsStatusNotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("Failure", "SelectQuestionAnsStatus not found"));
       }
   }

    @GetMapping("/all")
    public List<SelectQuestionAnsStatus> getAllSelectQuestionAnsStatus(){
        return selectQuestionAnsStatusService.getAllSelectQuestionAnsStatus();
    }

    @GetMapping("/get/{selectedQuestionId}")
      public ResponseEntity<Optional<Object>>showSelectQuestionAnsStatus(@PathVariable("selectedQuestionId")Integer selectedQuestionId){
        try{
            Optional<Object>selectedQuestionById=Optional.ofNullable(this.selectQuestionAnsStatusService.getSelectQuestionAnsStatusById(selectedQuestionId));
            if(selectedQuestionById.isPresent()){
                return ResponseEntity.ok(selectedQuestionById);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }
}

@DeleteMapping("/delete/{selectedQuestionId}")
     public ResponseEntity<String>deleteSelectQuestionAnsStatus(@PathVariable("selectedQuestionId")Integer selectedQuestionId){
        try{
            this.selectQuestionAnsStatusService.deleteSelectQuestionAnsStatus(selectedQuestionId);
            return ResponseEntity.ok("Deleted Sucessfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to deleted:"+e.getMessage());
        }
     }


    @PutMapping("/update/{selectedQuestionId}")
    public ResponseEntity<SelectQuestionAnsStatus> updateSelectQuestionAnsStatus(
            @PathVariable("selectedQuestionId") Integer selectedQuestionId,
            @RequestBody SelectQuestionAnsStatusDto selectQuestionAnsStatusDto) {
        try {
            SelectQuestionAnsStatus updatedStatus = selectQuestionAnsStatusService.updateSelectQuestionAnsStatus(selectQuestionAnsStatusDto, selectedQuestionId);
            return ResponseEntity.ok(updatedStatus);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
