package com.example.hw17_week4.Service;


import com.example.hw17_week4.Exception.ApiException;
import com.example.hw17_week4.Model.User;
import com.example.hw17_week4.Repository.User_Repository;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class User_Service {

    private final User_Repository userRepository;

    public List<User> getuser(){
        return userRepository.findAll();
    }

    public void adduser(User users){
    userRepository.save(users);
    }


    public void updateuser(Integer id, User new_users){
        User user = userRepository.getById(id);
        user.setAge(new_users.getAge());
        user.setName(new_users.getName());
        user.setEmail(new_users.getEmail());
        user.setRole(user.getRole());
        userRepository.save(user);

    }

    public void deleteUser(Integer id){
        User del_user = userRepository.getById(id);
            userRepository.deleteById(id);

    }

/*    public boolean updateuser(Integer id, User new_users){
        User user = userRepository.getById(id);

        if(new_users == null){
            return false;
        }
        user.setAge(new_users.getAge());
        user.setName(new_users.getName());
        user.setEmail(new_users.getEmail());
        user.setRole(user.getRole());
        userRepository.save(user);
        return true;
    }*/

   /* public boolean deleteUser(Integer id){
      User del_user = userRepository.getById(id);

        if(del_user.getId()== id){
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }*/

    public User findUserByEmail(String email){
        User USER = userRepository.findUserByEmail(email);
        if(USER == null){
            throw new ApiException("Incorrect input.");
        }
        return USER;
    }

    public User findUserByRole(String role){
        User USER = userRepository.findUserByRole(role);
        if(USER == null){
            throw new ApiException("Incorrect input.");
        }
        return USER;
    }

    public List<User> findUserByAge(Integer age){
        List<User> user =  userRepository.findAllByAgeIsGreaterThanEqual(age);
        if(user == null){
            throw new ApiException("Incorrect input.");
        }
        return user;
    }

    public User findUserByPassword(String username, String password) {
            User user = userRepository.findUserByUsernameAndPassword(username, password);
            if (user == null) {
                throw new ApiException("Incorrect input.");
            }
            return user;
        }




}
