package com.example.week6_hw27.Service;

import com.example.week6_hw27.ApiException;
import com.example.week6_hw27.Model.Blog;
import com.example.week6_hw27.Model.MyUser;
import com.example.week6_hw27.Repository.Blog_Repository;
import com.example.week6_hw27.Repository.MyUser_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUser_Service {

    private final MyUser_Repository myUser_repository;

    private final Blog_Repository blog_repository;

    public List<MyUser> getAllUsers(){
        return myUser_repository.findAll();
    }

    public MyUser getUserById(Integer id){
        MyUser myUser=myUser_repository.findMyUserById(id);
        if (myUser==null){
            throw new ApiException("User Not Found!");
        }
        return myUser;
    }

    public void register(MyUser myUser){
        myUser.setRole("User");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUser_repository.save(myUser);
    }

    public void UserAssingedToBlog(Integer user_id, Integer blog_id){
        MyUser myUser = myUser_repository.findMyUserById(user_id);
        Blog blog = blog_repository.findBlogById(blog_id);
        if (myUser == null || blog == null){
            throw new ApiException("User or Blog not found");
        }
        blog.setMyUser(myUser);
        blog_repository.save(blog);
    }
}
