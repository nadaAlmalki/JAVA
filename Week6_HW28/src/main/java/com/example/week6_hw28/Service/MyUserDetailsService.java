package com.example.week6_hw28.Service;

import com.example.week6_hw28.Model.MyUser;
import com.example.week6_hw28.Repository.MyUser_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MyUser_Repository myUser_repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser my_user=myUser_repository.findMyUserByUsername(username);
        if(my_user==null){
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return my_user;
    }
}
