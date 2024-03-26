package com.example.Project06.Repository;

import com.example.Project06.Entity.Blogs;
import com.example.Project06.Entity.Job;
import com.example.Project06.Entity.TpoStudentData;
import com.example.Project06.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpoStudentDataRepo extends JpaRepository<TpoStudentData, Integer> {
    List<TpoStudentData> findByuserId(Integer userId);

}
