package com.example.week3_hw13.CustomerPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Customers {

    // ID , Username , Balance
    private String ID;
    private String Username;
    private double Balance = 0.0;


  /*  public int getBalance() {
        return this.Balance;
    }*/


    public static double Deposit(int amount, Customers account) {

        // int balance =0;
        account.Balance= account.Balance + amount;
        return account.Balance;
    }

    public static double Withdraw(int amount, Customers account) {

        if (account.Balance > amount) {
            account.Balance = account.Balance - amount;
            return account.Balance;
        } else {
            return 0;
        }
    }



}
