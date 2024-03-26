package com.example.Project06.Controller;
import com.example.Project06.Dto.*;
import com.example.Project06.exception.UserPlanNotFoundException;
import com.example.Project06.Service.UserPlanService;
import com.example.Project06.exception.PlanNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserPlan")
@RequiredArgsConstructor
public class UserPlanController {
    @Autowired
    UserPlanService userPlanService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDto1> createUserPlan(@RequestBody UserPlanDto userPlanDto) {
        try {
            String result = userPlanService.addUserPlan(userPlanDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        } catch (UserPlanNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("error", e.getMessage()));
        }
    }

    @GetMapping("/getPlan")
    public ResponseEntity<GetPlanResponseDto> FindPlanById(@RequestParam Integer userPlanId) {
        try {
            GetPlanResponseDto getPlanResponseDto =new GetPlanResponseDto("success message");
            UserPlanDto byId = userPlanService.getById(userPlanId);
            getPlanResponseDto.setObject(byId);
            return ResponseEntity.status(HttpStatus.OK).body(getPlanResponseDto);
        } catch (UserPlanNotFoundException userPlanNotFoundException){
            GetPlanResponseDto unsuccess =new GetPlanResponseDto("Unsuccess message");
            unsuccess.setException("unsucees message 2");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(unsuccess);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserPlanDto>> allUserPlans() {
        try {
            List<UserPlanDto> userplans = this.userPlanService.getAllUserPlans();
            return ResponseEntity.ok(userplans);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{userPlanId}")
    public ResponseEntity<ResponseDto> updateUserPlan(@RequestBody UserPlanDto userPlanDto, @PathVariable Integer userPlanId) {
        try {
            String result = userPlanService.updateUserPlan(userPlanDto,userPlanId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", "updated"));
        }catch (PlanNotFoundException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));

        }
    }
    @DeleteMapping("/delete/{userPlanId}")
    public ResponseEntity<ResponseDto> deleteUserPlan(@PathVariable Integer userPlanId) {
        try {
            String result = userPlanService.deleteById(userPlanId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (UserPlanNotFoundException userPlanNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));
        }
    }

}
