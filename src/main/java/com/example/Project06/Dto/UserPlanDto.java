package com.example.Project06.Dto;

import com.example.Project06.Entity.UserPlan;
import lombok.Data;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPlanDto {
    private Integer userPlanId;

    private Integer userId;

    private Integer planId;


    private Integer payId;

    private String status;


    public UserPlanDto(UserPlan userPlan) {
        this.userPlanId = userPlan.getUserPlanId();
        this.userId = userPlan.getUserId();
        this.planId = userPlan.getPlanId();
        this.payId = userPlan.getPayId();
        this.status = userPlan.getStatus();
    }


}
