package com.priyavrat.Restful.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.priyavrat.Restful.Entity.User;
import com.priyavrat.Restful.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class)
class UserControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserRepository userRepository;

    User USER1= new User(1,"Priyavrat", LocalDateTime.of(1994, 3, 5, 10, 32, 12, 640000));
    User USER2= new User(2,"Richa", LocalDateTime.of(1994, 8, 25, 10, 32, 13, 640000));
    User USER3= new User(3,"Richu", LocalDateTime.of(1994, 8, 5, 10, 32, 14, 640000));

    @Test
    void retrieveAllUsers() {
    }

    @Test
    void retrieveUser() {
    }

    @Test
    void createUser() {
    }
}