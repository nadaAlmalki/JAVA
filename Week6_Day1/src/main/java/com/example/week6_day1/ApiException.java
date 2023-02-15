package com.example.week6_day1;

public class ApiException extends RuntimeException{
    public  ApiException(String message){
        super(message);
    }
}