package com.example.onetomany.Repository;


import com.example.onetomany.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Merchant_Repository extends JpaRepository<Merchant, Integer> {
    Merchant findMerchantById(Integer id);
}
