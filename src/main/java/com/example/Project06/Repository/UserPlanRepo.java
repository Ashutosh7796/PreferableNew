package com.example.Project06.Repository;

import com.example.Project06.Dto.UserPlanDto;
import com.example.Project06.Entity.UserPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlanRepo extends JpaRepository<UserPlan, Integer> {
    public List<UserPlanDto> getByUserId(Integer userId);

}
