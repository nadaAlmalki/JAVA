package com.example.onetomany.Services;

import com.example.onetomany.ApiException.ApiException;
import com.example.onetomany.Model.Branch;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Repository.Branch_Repository;
import com.example.onetomany.Repository.Merchant_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Merchant_Services {
    private final Merchant_Repository merchant_repository;
    private final Branch_Repository branch_repository;

    public List<Merchant> getMerchant(){
        return merchant_repository.findAll();
    }

    public void addMerchant(Merchant merchant){
        merchant_repository.save(merchant);
    }


    public void updateMerchant(Integer id, Merchant merchant){
        Merchant mrch = merchant_repository.findMerchantById(id);
        if (mrch == null){
            throw new ApiException("merchant not found");
        }
        mrch.setName(merchant.getName());
        merchant_repository.save(mrch);
    }

    public void deleteMerchant(Integer id){
        Merchant merchant = merchant_repository.findMerchantById(id);
        if (merchant == null){
            throw new ApiException("merchant not found");
        }
        merchant_repository.deleteById(id);

    }

}
