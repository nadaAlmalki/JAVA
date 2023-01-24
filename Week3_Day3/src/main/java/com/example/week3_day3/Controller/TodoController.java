package com.example.week3_day3.Controller;

import com.example.week3_day3.Pojo.TodoPojo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    ArrayList<TodoPojo> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TodoPojo> gettodo(){
        return tasks;
    }

    @PostMapping("/add")
    public String addtodo(@RequestBody TodoPojo task){
        tasks.add(task);
        return "tasks Added!";
    }

    @PutMapping("/update/{index}")
    public String updatetodo(@PathVariable int index, @RequestBody TodoPojo task){
        tasks.set(index, task);
        return "Tasks updated!";
    }

    @DeleteMapping("/delete/{index}")
    public String deletetodo(@PathVariable int index){
        tasks.remove(index);
        return "DONE";
    }
}
