package com.example.homework21.Services;

import com.example.homework21.ApiException;
import com.example.homework21.DTO.AddressDetailDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.Address_Repository;
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

    public List<Teacher> get_Teacher() {
        return teacher_repository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacher_repository.save(teacher);
    }


    public void updatTeacher(Integer id, Teacher teacher){
        Teacher tech = teacher_repository.findTeacherById(id);
        tech.setName(teacher.getName());
        tech.setAge(teacher.getAge());
        tech.setEmail(teacher.getEmail());
        tech.setSalary(teacher.getSalary());
        teacher_repository.save(tech);

    }

    public void deleteTeacher(Integer id){
        Teacher tech = teacher_repository.findTeacherById(id);
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

}