package com.example.Project06.Repository;

import com.example.Project06.Entity.ExamAns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamAnsRepo extends JpaRepository<ExamAns,Integer> {

}
