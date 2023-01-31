package com.example.hw17_week4.Repository;

import com.example.hw17_week4.Model.User;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface User_Repository extends JpaRepository<User,Integer> {
        User findUserByEmail(String email);

       User findUserByRole(String role);

   /* @Query("select u from User u where u.age >= ?1")
    User findAllByAge( Integer age);*/

         List<User> findAllByAgeIsGreaterThanEqual(Integer age);


    User findUserByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);
    User findUserByPassword(String password);








}


