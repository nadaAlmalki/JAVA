package com.example.week3_hw13.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Tasks {

    // ID , title , description , status
    private String ID;
    private String title;
    private String description;

    private String status;


    public boolean setStatus(String status) {
        this.status = status;
        return false;
    }



}
