package com.example.Project06.Repository;

import com.example.Project06.Entity.JobScreenAns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobScreenAnsRepo  extends JpaRepository<JobScreenAns,Integer>
{


}
