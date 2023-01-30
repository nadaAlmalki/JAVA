package com.example.hw17_week4.Service;


import com.example.hw17_week4.Model.User;
import com.example.hw17_week4.Repository.User_Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean updateuser(Integer id, User new_users){
        User user = userRepository.getById(id);

        if(new_users != null){
            return false;
        }

        user.equals(new_users.getId());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Integer id){
      User del_user = userRepository.getById(id);

        if(del_user.getId()== id){
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
