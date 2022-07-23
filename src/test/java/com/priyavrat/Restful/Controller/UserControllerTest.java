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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
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
    void retrieveAllUsersTest() throws Exception {
        List<User> users= new ArrayList<>(Arrays.asList(USER1,USER2,USER3));
        Mockito.when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users-rest/users")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].name",is("Richu")));
    }

    @Test
    void retrieveUserTest() throws Exception {
        Mockito.when(userRepository.findById(USER1.getId())).thenReturn(Optional.of(USER1));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users-rest/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("Priyavrat")));
    }

    @Test
    void createUserTest() throws Exception {
        User user = User.builder().id(1).name("Priyavrat").birthDate(LocalDateTime.of(1994, 3, 5, 10, 32, 12, 640000)).build();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        MockHttpServletRequestBuilder mockRequest =MockMvcRequestBuilders.post("/users-rest/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user));
        mockMvc.perform(mockRequest)
                .andExpect(status().is(201));
    }

    @Test
    void deleteUserTest() throws Exception{
        Mockito.when(userRepository.findById(USER2.getId())).thenReturn(Optional.of(USER2));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/users-rest/users/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}