package com.example.Project06.Service;
import com.example.Project06.Dto.UserPlanDto;
import com.example.Project06.exception.ResourceNotFoundException;

import java.util.List;

public interface UserPlanService {
    String addUserPlan(UserPlanDto userPlanDto);
    public UserPlanDto getById(Integer userPlanId);
    public List<UserPlanDto> getAllUserPlans();
    public String updateUserPlan(UserPlanDto userPlanDto, Integer userPlanId);


    String deleteById(Integer userPlanId);

}