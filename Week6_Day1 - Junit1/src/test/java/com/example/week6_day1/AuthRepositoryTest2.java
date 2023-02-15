package com.example.week6_day1;

import com.example.week6_day1.Model.MyUser;
import com.example.week6_day1.Model.Todo;
import com.example.week6_day1.repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthRepositoryTest2{
     @Autowired
    AuthRepository authRepository;

    MyUser myUser1 ;

    @BeforeEach
    void setUp() {


        myUser1 = new MyUser(null, "nada", "1122", "admin", null);

    }
@Test

public void findTodoById() {
    authRepository.save(myUser1);

    MyUser user = authRepository.findMyUserById(myUser1.getId());
    Assertions.assertThat(user).isEqualTo(myUser1);
}
/*    @Test
    public void findMyUserByUsernameTest(){
       authRepository.save(myUser1);
         MyUser user1 = authRepository.findMyUserByUsername(myUser1.getUsername());
        Assertions.assertThat(user1).isEqualTo(myUser1);
    }*/

}
