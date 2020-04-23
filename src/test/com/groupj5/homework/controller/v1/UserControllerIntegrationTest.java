package com.groupj5.homework.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.service.UserService;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void getAllUsers() throws Exception {

        UserDTO testUser = new UserDTO();
        testUser.setUserPk("1234543");
        testUser.setSurname("Surname");
        testUser.setName("Name");
        testUser.setStatus(0);
        testUser.setEmail("e@e.com");
        testUser.setAddress("Address t2 - 80");
        testUser.setTime(DateUtil.truncateTime(new Date()));

        List<UserDTO> allUsers= Collections.singletonList(testUser);

        given(service.getAllUsers()).willReturn(allUsers);

        mvc.perform(get("/api/v1/rest/User/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allUsers))));

    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void updateUser1() {
    }

    @Test
    void findByUserPkAndStatus() {
    }
}