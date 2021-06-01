package com.harryman.securitydemo2.data.repository;

import com.harryman.securitydemo2.data.model.user.User;
import com.harryman.securitydemo2.data.model.user.Usersex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user= new User();
    @BeforeEach
    void setUp() {

    }

    @Test
    void saveUserTest(){
        user.setFirstname("Tim");
        user.setLastName("Graw");
        user.setUsername("timG");
        user.setUsersex(Usersex.MALE);
        user.setAddress("1, Dada street, Ojo, Lagos");
        user.setEmail("tg@gmail.com");
        user.setPhoneNumber("080-5555-7777");
        user.setPassword("tg123");

        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    void updateUserTest(){
        user = userRepository.findById(1).orElse(null);
        user.setLastName("Combs");
        userRepository.save(user);

        assertThat(user.getLastName()).isEqualTo("Combs");
    }

    @Test
    void findUserByIdTest(){
        user = userRepository.findById(1).orElse(null);
        assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    void findAllUserTest(){
        List<User> getUser = userRepository.findAll();
        assertThat(getUser.size()).isEqualTo(2);
    }

    @Test
    void deleteUserByIdTest(){
        userRepository.deleteById(2);
        assertThat(userRepository.existsById(2)).isFalse();
    }
}