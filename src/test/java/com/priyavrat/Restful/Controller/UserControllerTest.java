package com.priyavrat.Restful.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.priyavrat.Restful.Entity.User;
import com.priyavrat.Restful.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void retrieveAllUsers() throws Exception {
        List<User> users= new ArrayList<>(Arrays.asList(USER1,USER2,USER3));
        Mockito.when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].name",is("Richu")));
    }

    @Test
    void retrieveUser() {
    }

    @Test
    void createUser() {
    }
}