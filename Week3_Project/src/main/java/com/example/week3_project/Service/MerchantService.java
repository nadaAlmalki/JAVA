package com.example.week3_project.Service;


import com.example.week3_project.Pojo.MerchantPojo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<MerchantPojo> Marchan = new ArrayList<>();


    public ArrayList<MerchantPojo> getMarchan(){
        return Marchan;

    }

    public void addMarchan(MerchantPojo marchan){
        Marchan.add(marchan);
    }

    public boolean updateMarchan(String id, MerchantPojo marchan){
        for (int i=0; i< Marchan.size(); i++){
            if(Marchan.get(i).getMerchan_id() == id){
                Marchan.set(i,marchan);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMarchan(String id){
        for (int i=0; i<Marchan.size(); i++){
            if(Marchan.get(i).getMerchan_id() == id){
                Marchan.remove(i);
                return true;
            }

        }
        return false;
    }
}
