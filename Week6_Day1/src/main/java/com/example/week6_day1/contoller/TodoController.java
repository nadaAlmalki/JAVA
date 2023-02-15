package com.example.week6_day1.contoller;

import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.Model.Todo;
import com.example.week6_day1.dto.Response;
import com.example.week6_day1.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {
    private TodoService todoService;

    @GetMapping("/get")
    public ResponseEntity <List<Todo>> getTodos(@AuthenticationPrincipal MyUser myUser){
       // return ResponseEntity.status(200).body(todoService.getTodos(myUser.getId()));
        return ResponseEntity.status(200).body(todoService.getTodos());
    }

    @PostMapping("/add")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser.getId(), todo);
        return ResponseEntity.status(201).body(new Response("New Todo added !",201));
    }

    @DeleteMapping("delete/{todoId}")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser.getId(),todoId);
        return ResponseEntity.status(200).body(new Response("Todo deleted !",200));
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity updateTodos( @PathVariable Integer todoId,@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo) {
        todoService.updateTodo(todoId,todo);
        return ResponseEntity.status(200).body("myUser updated");

    }

}
