package com.example.final_project.Repository;

import com.example.final_project.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Coach_Repository extends JpaRepository<Coach, Integer> {
    Coach findCoachById(Integer id);


}
