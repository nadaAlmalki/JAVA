package com.example.hw17_week4.Repository;

import com.example.hw17_week4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User,Integer> {
}
