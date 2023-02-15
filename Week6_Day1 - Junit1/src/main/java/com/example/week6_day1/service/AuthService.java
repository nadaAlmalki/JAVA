package com.example.week6_day1.service;

import com.example.week6_day1.ApiException;
import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {





        private final AuthRepository authRepository;


        public void register(MyUser myUser) {
            myUser.setRole("USER");
            String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
            myUser.setPassword(hashedPassword);
           // authRepository.save(myUser);
            authRepository.save(myUser);

        }

    public List<MyUser> getAllUsers(){
        return authRepository.findAll();
    }

    public MyUser getUserById(Integer id){
        MyUser myUser=authRepository.findMyUserById(id);
        if (myUser==null){
            throw new ApiException("User Not Found!");
        }
        return myUser;
    }

}
