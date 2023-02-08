package com.example.homework21.Repository;

import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface Student_Repository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);

    //@Query("select Student from Course where  Course.id =?1")
    List<Student> getStudentByCourseId(Integer id);

    Student findStudentByIdAndMajor(Integer id , String major);



}

