package com.example.Project06.Entity;

import com.example.Project06.Dto.UserPlanDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "UserPlans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPlan {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPlanId;

    @Column
    private Integer userId;

    @Column
    private Integer planId;

    @Column
    private Integer payId;

    @Column(length = 45)
    private String status;

    public UserPlan(UserPlanDto userPlanDto){
        this.userPlanId = userPlanDto.getUserPlanId();
        this.userId = userPlanDto.getUserId();
        this.planId = userPlanDto.getPlanId();
        this.payId = userPlanDto.getPayId();
        this.status = userPlanDto.getStatus();
    }



}
