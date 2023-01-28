package com.example.week3_project.Service;


import com.example.week3_project.Pojo.MerchantPojo;
import com.example.week3_project.Pojo.MerchantStockPojo;
import com.example.week3_project.Pojo.Product_Pojo;
import com.example.week3_project.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<UserPojo> users = new ArrayList<>();

    ArrayList<Product_Pojo> products = new ArrayList<>();
    ArrayList<MerchantPojo> merchn = new ArrayList<>();
    ArrayList<MerchantStockPojo> merchn_stock = new ArrayList<>();
    @Autowired
    private Product_Service pro;
    @Autowired
    private MerchantStockService stock;
    @Autowired
    private MerchantService merchn2;

    public ArrayList<UserPojo> getUsers() {
        return users;
    }

    public void adduser(UserPojo new_user) {
        users.add(new_user);
    }


    public boolean updateuser(UserPojo user, String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUser_id() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteuser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUser_id() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;

    }


    public boolean buy_pro(Product_Pojo product, MerchantPojo merchant, MerchantStockPojo stock, UserPojo user, String userid, String pro_id, String
            merchan_id) {
        for (int i = 0; (i < users.size()) && (i< products.size()) && (i < merchn_stock.size()); i++) {
            if (users.remove(i).getUser_id() == userid && products.get(i).getPro_id() == pro_id && merchn_stock.get(i).getStock_id() == merchan_id) {
                users.remove(i);
                products.remove(i);
                merchn_stock.remove(i);
                return true;
            }
        else if (merchn_stock.get(i).getProductid()== pro_id){
                int i1 = merchn_stock.get(i).getStock() - 1;
                int new_balance = user.getBalance()- product.getPrice();
                return true;
        }

        }
        return false; }
}