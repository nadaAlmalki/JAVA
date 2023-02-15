package com.example.week6_day1;

import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.Model.Todo;
import com.example.week6_day1.repository.AuthRepository;
import com.example.week6_day1.repository.TodoRepository;
import com.example.week6_day1.service.AuthService;
import com.example.week6_day1.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @InjectMocks
    AuthService authService;
    @Mock
    AuthRepository authRepository;
    @Mock
    TodoRepository todoRepository;

    MyUser myUser,myUser2, myUser3;

    Todo todo1, todo2, todo3;

    List<MyUser> users;

    List<Todo> todos;
    @BeforeEach
    void setup(){
        myUser = new MyUser(null, "malk", "1133", "ADMIN",null);
          myUser2 = new MyUser(null, "naada", "1123", "admin", null);

        myUser3 = new MyUser(null, "salem", "1124", "admin", null);
        todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }

    @Test
    public void getAllUsersTest(){
        when(authRepository.findAll()).thenReturn(users);
         authService.getAllUsers();
        List<MyUser> all = verify(authRepository, times(1)).findAll();
    }


    public MyUser getUserById(Integer id){
        MyUser myUser=authRepository.findMyUserById(id);
        if (myUser==null){
            throw new ApiException("User Not Found!");
        }
        return myUser;
    }
    @Test
    public void getUserByIdTest(){
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
       authService.getUserById(myUser.getId());
       verify(authRepository, times(1)).findMyUserById(myUser.getId());
    }

}