package com.example.week6_hw28.Repository;

import com.example.week6_hw28.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUser_Repository extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserByUsername(String username);

    MyUser findMyUserById(Integer id);

    MyUser findAllByIdAndRole(Integer id,String role);
}
