package com.example.week6_hw28.Service;


import com.example.week6_hw28.ApiException;
import com.example.week6_hw28.Model.MyUser;
import com.example.week6_hw28.Model.Orders;
import com.example.week6_hw28.Repository.MyUser_Repository;
import com.example.week6_hw28.Repository.Order_Repository;
import com.example.week6_hw28.Repository.Product_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUser_Service {

    private final MyUser_Repository myUser_repository;
    private final Order_Repository order_repository;
    private final Product_Repository product_repository;


    //Get all customer orders
    public List<MyUser> getAllUsers(){
        return myUser_repository.findAll();
    }


    public void register(MyUser myUser){
        myUser.setRole("User");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUser_repository.save(myUser);
    }


    //Get order - customer - product by Id
    public MyUser getMyUserById(Integer id){
        MyUser user = myUser_repository.findMyUserById(id);
        if (user==null){
            throw new ApiException("User Not Found!");
        }
        return user;
    }
    public void OrderAssingedToUser(Integer user_id, Integer order_id){
        MyUser myUser = myUser_repository.findMyUserById(user_id);
        Orders orders = order_repository.findMyOrderById(order_id);
        if (myUser == null || orders == null){
            throw new ApiException("User or Order not found");
        }
        orders.setMyUser(myUser);
        order_repository.save(orders);
    }


}
