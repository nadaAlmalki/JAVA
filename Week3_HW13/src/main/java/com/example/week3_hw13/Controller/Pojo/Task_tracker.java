package com.example.week3_hw13.Controller.Pojo;

import com.example.week3_hw13.Pojo.Tasks;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/sys")
public class Task_tracker {

    ArrayList<Tasks> Taskk = new ArrayList<>();

    @PostMapping("/add")
    public String addtask(@RequestBody Tasks task1){
        Taskk.add(task1);
        return "Task added!";
    }

    @GetMapping("/get")
    public ArrayList<Tasks> gettasks(){
        return Taskk;
    }

    @PutMapping("/update/{index}")
    public String updatetask(@PathVariable int index, @RequestBody Tasks task1){
        Taskk.set(index, task1);
        return "Update Successful";
    }
    @DeleteMapping("/delete/{index}")
    public String deletetodo(@PathVariable int index) {
        Taskk.remove(index);
        return "DONE";
    }
@GetMapping("/search")
  public String search(){
        for (int index = 0; index < Taskk.size(); index++)
            //   System.out.println(Taskk.get(1).getTitle());
       return "Title is: "+Taskk.get(1).getTitle();
    return null;
}


    @PutMapping("/updatestatus")
    public ArrayList<Tasks> updatestatus() {

        int i;
        for (i = 0; i < Taskk.size(); i++)
            if (Taskk.get(i).getStatus().equals("Not Done"))
                System.out.println("Status Change to Done: "+Taskk.get(i).setStatus("Done"));
            else
                System.out.println("Status Change to Not Done: "+Taskk.get(i).setStatus("Not Done"));
       return Taskk;
    }

}
