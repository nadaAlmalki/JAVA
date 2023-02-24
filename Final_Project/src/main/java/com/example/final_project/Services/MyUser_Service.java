package com.example.final_project.Services;

import com.example.final_project.ApiException;
import com.example.final_project.Model.MyUser;
import com.example.final_project.Repository.MyUser_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUser_Service {

   private final MyUser_Repository myUserRepository;

    public List<MyUser> getUser(){
       return myUserRepository.findAll();
    }

    public void addUser(MyUser myUser){
        myUserRepository.save(myUser);
    }

    public void updateUser(Integer id, MyUser newUser){
        MyUser oldUser = myUserRepository.findMyUserById(id);
        if(oldUser == null ){
            throw new ApiException("User not found");
        }
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setRole(newUser.getRole());
        myUserRepository.save(oldUser);
    }

    public void deleteUser(Integer id){
        MyUser user= myUserRepository.findMyUserById(id);
        if(user == null){
            throw new ApiException("User Not found");
        }
       // myUserRepository.deleteById(id);
        myUserRepository.delete(user);
    }
}
