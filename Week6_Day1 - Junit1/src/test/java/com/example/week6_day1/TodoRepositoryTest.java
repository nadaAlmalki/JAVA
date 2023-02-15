package com.example.week6_day1;

import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.Model.Todo;
import com.example.week6_day1.repository.AuthRepository;
import com.example.week6_day1.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    AuthRepository authRepository;
    MyUser myUser;

    Todo todo1, todo2, todo3;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(null, "nada", "1122", "admin", null);

        todo1 = new Todo(null, "todo1", myUser.getId(),myUser);
        todo2 = new Todo(null, "todo2", myUser.getId(), myUser);
        todo3 = new Todo(null, "todo3", myUser.getId(), myUser);

    }

    @Test
    public void findAllByUserId(){
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        List<Todo> todoList = todoRepository.findAllByMyUser(myUser);
     Assertions.assertThat(todoList.get(0).getMyUser().getId().equals(myUser.getId()));

    }

    @Test
    public void findTodoById() {
        todoRepository.save(todo1);

        Todo todo = todoRepository.findTodoById(todo1.getId());
        Assertions.assertThat(todo).isEqualTo(todo1);
    }

}
