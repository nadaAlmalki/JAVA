package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.DTO.TeacherDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Address_Repository;
import com.example.homework21.Repository.Teacher_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final Teacher_Repository teacher_repository;
    private final Address_Repository address_repository;

    public List<Teacher> get_Teacher(){
        return teacher_repository.findAll();
    }

    public void add_method (Teacher teacher){
        teacher_repository.save(teacher);
    }
    public void add_teacher(TeacherDetailDTO teacherDetailDTO){
         Address address1 = address_repository.findAddressById(teacherDetailDTO.getTeacher_id());
        //Teacher teacher = teacher_repository.findTeacherById((teacherDetailDTO.getTeacher_id()));
       // Address address = new Address();
        if(address1.getId() == null){
            throw new ApiException("Address Not found");
        }
        Teacher teacher = new Teacher(null,null,teacherDetailDTO.getAge(), teacherDetailDTO.getEmail(),teacherDetailDTO.getSalary(),address1);
        teacher_repository.save(teacher);
    }

    public void updateTeacherDetails(Integer id, TeacherDetailDTO teacherDTO){
        Teacher teacher= teacher_repository.findTeacherById(teacherDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        teacher.setAge(teacherDTO.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSalary(teacherDTO.getSalary());
        teacher_repository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacher_repository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("Teacher Details deleted");
        }
        teacher_repository.delete(teacher);

    }

}
