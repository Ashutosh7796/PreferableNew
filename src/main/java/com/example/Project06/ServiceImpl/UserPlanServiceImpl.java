package com.example.Project06.ServiceImpl;
import com.example.Project06.Dto.UserPlanDto;
import com.example.Project06.Entity.*;
import com.example.Project06.exception.UserPlanNotFoundException;
import com.example.Project06.Repository.PaymentRepo;
import com.example.Project06.Repository.PlanRepository;
import com.example.Project06.Repository.UserPlanRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPlanServiceImpl implements UserPlanService {
    @Autowired
    private UserPlanRepo userPlanRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public String addUserPlan(UserPlanDto userPlanDto) {
        if (userRepository.existsById(userPlanDto.getUserId()) &&
                planRepository.existsById(userPlanDto.getPlanId()) && paymentRepo.existsById(userPlanDto.getPayId())) {
            UserPlan userPlan = new UserPlan(userPlanDto);
            userPlan.setUserId(userPlanDto.getUserId());
            userPlan.setPlanId(userPlanDto.getPlanId());
            userPlan.setPayId(userPlanDto.getPayId());
            userPlan.setStatus(userPlanDto.getStatus());
            userPlanRepo.save(userPlan);
            return "User Plan added successfully";
        } else {
            throw new UserPlanNotFoundException("ID not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserPlanDto getById(Integer userPlanId) {
        Optional<UserPlan> byuserPlanId = userPlanRepo.findById(userPlanId);
        if (byuserPlanId.isEmpty()){
            throw new UserPlanNotFoundException("User plan Not found", HttpStatus.NOT_FOUND);
        }
        UserPlanDto userPlanDto = new UserPlanDto(byuserPlanId.get());
        userPlanDto.setUserPlanId(userPlanId);
        return userPlanDto;
    }

    @Override
    public List<UserPlanDto> getAllUserPlans() {
        List<UserPlan> userPlans = userPlanRepo.findAll();
        return userPlans.stream()
                .map(UserPlanDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String updateUserPlan(UserPlanDto userPlanDto, Integer userPlanId) {
        try {
            UserPlan userPlan = userPlanRepo.findById(userPlanId).orElse(null);

            if (userPlan != null) {

                userPlan.setUserId(userPlanDto.getUserId());
                userPlan.setPlanId(userPlanDto.getPlanId());
                userPlan.setPayId(userPlanDto.getPayId());
                userPlan.setStatus(userPlanDto.getStatus());

                userPlanRepo.save(userPlan);
            }
        } catch (Exception e) {

        }
        return "updated successfully";
    }

    @Override
    public String deleteById(Integer userPlanId) {
        userPlanRepo.findById(userPlanId).orElseThrow(() -> new RuntimeException("UserPlan Not found By Id"));
        userPlanRepo.deleteById(userPlanId);
        return "userPlan deleted Successfully ";
    }


}
