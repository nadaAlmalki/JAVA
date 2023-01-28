package com.example.week3_project.Service;

import com.example.week3_project.Pojo.Product_Pojo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Product_Service {

    ArrayList<Product_Pojo> product = new ArrayList<>();

    public ArrayList<Product_Pojo> getProduct(){
        return product;
    }
    public boolean updateproduct(String id, Product_Pojo pro){
        for(int i =0; i<product.size(); i++){
           // if(product.get(i).getId() == id && product.get(i).getPrice() > 0){
            if(product.get(i).getPro_id() == id){
                product.set(i,pro);
                return true;
            }
        }
        return false;
    }

    public void addproduct( Product_Pojo pro){
        product.add(pro);
    }

    public boolean deleteproduct(String id){
        for(int i =0; i < product.size(); i++ ){
            if(product.get(i).getPro_id() == id){
                product.remove(i);
                return true;
            }
        }
        return false;
    }

}
