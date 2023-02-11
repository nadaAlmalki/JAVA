package com.example.week5_project5.Repository;

import com.example.week5_project5.Model.Location;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Location_Repository extends JpaRepository<Location, Integer> {

    Location findLocationById(Integer id);
}
