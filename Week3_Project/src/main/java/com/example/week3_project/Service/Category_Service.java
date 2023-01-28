package com.example.week3_project.Service;


import com.example.week3_project.Pojo.Category_Pojo;
import com.example.week3_project.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class Category_Service {

    ArrayList<Category_Pojo> category = new ArrayList<>();


    public ArrayList<Category_Pojo> getCategory() {
        return category;
    }


    public boolean updateCategory(String id, Category_Pojo cate){
        for (int i =0; i < category.size(); i++){
            if(category.get(i).getCat_id()== id){
                category.set(i,cate);
                return true;
            }
        } return false;

    }

    public void addCategory(Category_Pojo cat){
      category.add(cat);
    }

    public boolean deleteCategory(String id){
        for (int i=0; i<category.size(); i++){
            if(category.get(i).getCat_id() == id){
                category.remove(i);
                return true;
            }

        }
        return false;
    }



}
