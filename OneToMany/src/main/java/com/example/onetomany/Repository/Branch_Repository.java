package com.example.onetomany.Repository;

import com.example.onetomany.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Branch_Repository extends JpaRepository<Branch, Integer> {
    Branch findBranchById(Integer id);
}
