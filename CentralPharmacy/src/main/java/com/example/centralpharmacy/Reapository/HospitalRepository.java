package com.example.centralpharmacy.Reapository;

import com.example.centralpharmacy.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer>{
}
