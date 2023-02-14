package com.example.week6_hw27.Repository;

import com.example.week6_hw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUser_Repository extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserByUsername(String username);

    MyUser findMyUserById(Integer id);
}
