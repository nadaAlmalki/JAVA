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
public class Branch_Services {

    private final Branch_Repository branch_repository;
    private final Merchant_Repository merchant_repository;


    public List<Branch> getBranch(){
        return branch_repository.findAll();
    }

    public void addBranch(Branch branch){
        branch_repository.save(branch);
    }


    public void updateBranch(Integer id, Branch branch){
        Branch branches = branch_repository.findBranchById(id);
        if (branches == null){
            throw new ApiException("Branche not found");
        }
        branches.setArea(branch.getArea());
        branches.setNumber(branch.getNumber());
        branch_repository.save(branches);
    }

    public void deleteBranch(Integer id){
        Branch branches = branch_repository.findBranchById(id);
        if (branches == null){
            throw new ApiException("Branche not found");
        }
        branch_repository.deleteById(id);

    }

    public void assignMerchantToBranch(Integer merchant_id, Integer branch_id){
        Merchant merchant = merchant_repository.findMerchantById(merchant_id);
        Branch branch = branch_repository.findBranchById(branch_id);
        if(merchant == null || branch == null){
            throw new ApiException("Merchant or Branch not found");
        }

        branch.setMerchant(merchant);
        branch_repository.save(branch);

    }
}
