package com.example.homework21.Repository;

import com.example.homework21.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Address_Repository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);
}
