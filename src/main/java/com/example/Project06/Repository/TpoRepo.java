package com.example.Project06.Repository;

import com.example.Project06.Entity.Tpo;
import com.example.Project06.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TpoRepo extends JpaRepository<Tpo, Integer> {
    List<Tpo> findByUserUser(Integer userId);
}
