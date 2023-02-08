package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Course_Repository;
import com.example.homework21.Repository.Student_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Student_Service {
    private final Student_Repository student_repository;
    private final Course_Repository course_repository;

    public List<Student> getStudent() {
        return student_repository.findAll();
    }


    public void addStudent(Student student){
        student_repository.save(student);
    }


    public void updatStudent(Integer id, Student student){
        Student stud = student_repository.findStudentById(id);
        if(stud == null)
        {
            throw  new ApiException("Student not found");
        }
        stud.setName(student.getName());
        stud.setAge(student.getAge());
        stud.setMajor(student.getMajor());
        student_repository.save(stud);

    }

    public void deleteStudent(Integer id){
        Student student = student_repository.findStudentById(id);
        if(student == null)
        {
            throw  new ApiException("Student not found");
        }
        student_repository.deleteById(id);

    }
//Create endpoint that takes class id and return the student list
   public List<Student> ListStudents(Integer course_id) {
        Course course= course_repository.findCourseById(course_id);
       if (course == null) {
           throw new ApiException("Course not found");
       }
       return student_repository.getStudentByCourseId(course_id);
   }


//Create endpoint that takes student id and major and change the student major ( changing the major will drop all the cousres that the student attended to )
    public void updatMajor(Integer id, String major, Student student){
        Student stud = student_repository.findStudentByIdAndMajor(id, major);

        if(stud == null)
        {

            throw  new ApiException("Student not found");

        }

        stud.setMajor(student.getMajor());
        student_repository.save(stud);
       // course_repository.deleteById(student.getId());
        Course course = course_repository.deleteCoursesByStudentId(id);
       course_repository.save(course);
    }


}
