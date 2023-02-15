package com.example.week6_day1.repository;

import com.example.week6_day1.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findAllByUserId(Integer userId);

    Todo findTodoById(Integer id);


}
