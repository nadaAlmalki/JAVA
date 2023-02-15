package com.example.week6_day1;

import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.Model.Todo;
import com.example.week6_day1.repository.AuthRepository;
import com.example.week6_day1.repository.TodoRepository;
import com.example.week6_day1.service.TodoService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    TodoService todoService;
    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;

    MyUser myUser;

    Todo todo1, todo2, todo3;

    List<Todo> todos;
    @BeforeEach

    void setup(){
        myUser = new MyUser(null, "malk", "1133", "ADMIN",null);
        todo1 = new Todo(null, "todo1", myUser.getId(),myUser);
        todo2 = new Todo(null, "todo2", myUser.getId(), myUser);
        todo3 = new Todo(null, "todo3", myUser.getId(), myUser);

        todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }

    @Test
    public void getTodosTest() {
        when(todoRepository.findAll()).thenReturn(todos);
        List<Todo> todoList = todoService.getTodos();
        Assertions.assertEquals(3, todoList.size());
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    public void addTodoTest(){

        todoService.addTodo(todo1.getId(),todo1);
        verify(todoRepository,times(1)).save(todo1);

    }

    @Test
    public void updateTodoTest(){
            when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
            todoService.updateTodo(todo1.getId(),todo1);
            verify(todoRepository, times(1)).findTodoById(todo1.getId());
            verify(todoRepository,times(1)).save(todo1);
        }


    @Test
    public void removeTodoTest() {

        when(todoRepository.findTodoById(todo2.getId())).thenReturn(todo2);
             todoService.removeTodo(todo2.getId());
        verify(todoRepository, times(1)).findTodoById(todo2.getId());
        verify(todoRepository, times(1)).deleteById(todo2.getId());

    }
}
