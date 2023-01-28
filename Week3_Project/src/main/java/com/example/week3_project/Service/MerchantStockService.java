package com.example.week3_project.Service;

import com.example.week3_project.Pojo.MerchantPojo;
import com.example.week3_project.Pojo.MerchantStockPojo;
import com.example.week3_project.Pojo.Product_Pojo;
import com.example.week3_project.Pojo.UserPojo;

import com.example.week3_project.Resources.Shared_Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.example.week3_project.Resources.Shared_Data.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.week3_project.Resources.Shared_Data.*;

@Service
@RequiredArgsConstructor
public class MerchantStockService {


    ArrayList<MerchantStockPojo> MerchanStock = new ArrayList<>();


@Autowired
    private Product_Service pro;
    @Autowired
    private UserService user;
    @Autowired
    private MerchantService merchn2;


private Product_Pojo product;
    public ArrayList<MerchantStockPojo> getmchnStock() {
      //  Product_Pojo productPojo = Shared_Data.products.get(new Product_Pojo(String pro_id, String name, int price));
      // String products= product.getPro_id();
        return MerchanStock;
    }

    public void addmchnStock(MerchantStockPojo merchan_stock) {

        MerchanStock.add(merchan_stock);
    }


    public boolean updatemchnStock(String id, MerchantStockPojo merchan_stock) {
        for (int i = 0; i < MerchanStock.size(); i++) {
            if (MerchanStock.get(i).getStock_id() == id) {
                MerchanStock.set(i, merchan_stock);
                return true;
            }
        }
        return false;
    }

    public boolean deletemchnStock(String id) {
        for (int i = 0; i < MerchanStock.size(); i++) {
            if (MerchanStock.get(i).getStock_id() == id) {
                MerchanStock.remove(i);
                return true;
            }
        }
        return false;
    }




}