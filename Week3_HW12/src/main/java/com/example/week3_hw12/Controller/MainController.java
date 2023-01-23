package com.example.week3_hw12.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("hw")
public class MainController {

    @GetMapping("/name")
    public String name(){

        return "My name is Nada";
    }

    @GetMapping("/age")
    public String age(){

        return "My age is 26";
    }

    @GetMapping("check/status")
    public String status(){

        return "Everything OK";
    }

    @GetMapping("/health")
    public String health(){

        return "Server health is up and running";
    }


}