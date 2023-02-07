package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Address_Repository;
import com.example.homework21.Repository.Course_Repository;
import com.example.homework21.Repository.Teacher_Repository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final Teacher_Repository teacher_repository;
    private final Address_Repository address_repository;

    private final Course_Repository course_repository;

    public List<Teacher> get_Teacher() {
        return teacher_repository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacher_repository.save(teacher);
    }


    public void updatTeacher(Integer id, Teacher teacher){
        Teacher tech = teacher_repository.findTeacherById(id);
        if(tech == null)
        {
            throw  new ApiException("Teacher not found");
        }
        tech.setName(teacher.getName());
        tech.setAge(teacher.getAge());
        tech.setEmail(teacher.getEmail());
        tech.setSalary(teacher.getSalary());
        teacher_repository.save(tech);

    }

    public void deleteTeacher(Integer id){
        Teacher tech = teacher_repository.findTeacherById(id);
        if(tech == null)
        {
            throw  new ApiException("Teacher not found");
        }
        teacher_repository.deleteById(id);

    }

        //Add Address Details to Teacher
    public void add_details(AddressDetailDTO addressDTO){
        Teacher teacher = teacher_repository.findTeacherById((addressDTO.getTeacher_id()));

            if(teacher == null){
                throw new ApiException("Teacher Not found");
            }
      Address address = new Address(null,addressDTO.getArea(), addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        address_repository.save(address);
        }


    //Upadte Teacher Address Details
    public void updateTeacherAddress(AddressDetailDTO addressDTO, Integer id){
        Address addr = address_repository.findAddressById(addressDTO.getTeacher_id());
        if(addr == null){
            throw new ApiException("Teacher Address Not found");
        }

        addr.setStreet(addr.getStreet());
        addr.setArea(addressDTO.getArea());
        addr.setBuildingNumber(addr.getBuildingNumber());
        address_repository.save(addr);
    }

    //Delete Teacher Address Details
    public void deleteTeacherAddress(Integer id){
        Address addr = address_repository.findAddressById(id);
        if(addr == null){
            throw new ApiException("Addres Not found");
        }

        address_repository.delete(addr);
    }


   // Create endpoint that takes teacher id and return All teacher details

    public List<Teacher> get_TeacherDetails(Integer id, AddressDetailDTO addressDTO) {
        Teacher teacher = teacher_repository.findTeacherById((addressDTO.getTeacher_id()));
        if(teacher == null){
            throw new ApiException("Teacher Details Not found");
        }
        return teacher_repository.findAll();
    }


    public void CoursesTeachByTeacher(Integer teacher_id, Integer course_id){
        Teacher teacher= teacher_repository.findTeacherById(teacher_id);
        Course course = course_repository.findCourseById(course_id);
        if (teacher == null || course == null){
            throw new ApiException("Teacher or Courses not found");
        }
        course.setTeacher(teacher);
        course_repository.save(course);

    }

    public Teacher SearchByCoursId(Integer teacher_id, Integer course_id) {
        Course course = course_repository.findCourseById(course_id);
        Teacher tech = teacher_repository.findTeacherById(teacher_id);
        if(tech != null && course.getId() == course_id){
            tech = teacher_repository.findTeacherByName(tech.getName());
            return tech;

        }

        throw new ApiException("Course not found");
    }


}