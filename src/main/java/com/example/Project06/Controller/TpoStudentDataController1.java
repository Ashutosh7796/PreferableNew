package com.example.Project06.Controller;

import com.example.Project06.Dto.*;
import com.example.Project06.Service.TpoStudentDataService;
import com.example.Project06.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tpostudentdata")
public class TpoStudentDataController1 {
    @Autowired
    private TpoStudentDataService tpoStudentDataService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto1> addTpoStudentData(@RequestBody TpoStudentDataDto tpoStudentDataDto, @RequestParam Integer userId){
        try {
            String s = tpoStudentDataService.addTpoStudentData(tpoStudentDataDto,userId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("Success",s ));
        }catch (TpoStudentDataAlreayExistsException TpoStusdentdataAlreadyExistException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("Unsuccess","TpoStudentdata Already Exist"));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Optional<Object>> showTpoStudentData(@RequestParam  Integer tpoStudentData/*,@RequestParam Integer userId*/){
        try {
            Optional<Object> dataById = Optional.ofNullable(this.tpoStudentDataService.getByTpoStudentDataById(tpoStudentData/*, userId*/));
            if (dataById.isPresent()) {
                return ResponseEntity.ok(dataById);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }


    }
    @GetMapping("/getAll")
    public ResponseEntity<List<TpoStudentDataDto>> allTpoStudentData() {
        try {
            List<TpoStudentDataDto> tpoStudentData = this.tpoStudentDataService.getAllTpoStudentData();
            return ResponseEntity.ok(tpoStudentData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto1> deleteTpoStudentData(@RequestParam Integer tpoStudentData) {
        try {
            String result = tpoStudentDataService.deleteById(tpoStudentData);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        } catch (RuntimeException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unSuccess", "Degree not found"));
        }

    }
    @PutMapping("/update/{tpoStudentData}")
    public ResponseEntity<ResponseDto> UpdateTpoStudentData(@RequestBody TpoStudentDataDto tpoStudentDataDto, @PathVariable Integer tpoStudentData) {
        try {
            String result = tpoStudentDataService.updateTpoStudentData(tpoStudentDataDto,tpoStudentData);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        }catch (TpoStudentDataIsNotfoundException tpoStudentDataIsNotfoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "TpoStudentData not found"));

        }
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<AllTpoStudentDataResponseDto> getJobsByUserId(@RequestParam Integer userId) {
        try {
            AllTpoStudentDataResponseDto allTpoStudentDataResponseDto = new AllTpoStudentDataResponseDto("success");
            List<TpoStudentDataDto> list = tpoStudentDataService.getByUserId(userId);
            allTpoStudentDataResponseDto.setList(list);
            return ResponseEntity.status(HttpStatus.OK).body(allTpoStudentDataResponseDto);
        } catch (TpoStudentDataIsNotfoundException tpoStudentDataIsNotfoundException) {
            AllTpoStudentDataResponseDto allTpoStudentDataResponseDto = new AllTpoStudentDataResponseDto("unsuccessful");
            allTpoStudentDataResponseDto.setException("TpoStudentData not found for user with ID:");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allTpoStudentDataResponseDto);
        }
    }

}