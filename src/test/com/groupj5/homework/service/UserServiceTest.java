package com.groupj5.homework.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupj5.homework.database.NoSQLDatabase;
import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.dto.mapper.UserMapper;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import com.groupj5.homework.service.validator.UserValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private NoSQLDatabase noSQLDatabase = mock(NoSQLDatabase.class);

    UserService userService = new UserService(userRepository,
            new UserMapper(),
            new UserValidator(), new ObjectMapper(), noSQLDatabase);


    @Test
    public void getUserByIdTest(){
        User user = new User();
        user.setSurname("S1");
        user.setUserPk("USERPK");


        when(userRepository.getOne(100L)).thenReturn(user);
        UserDTO userResult = userService.getUserById(100L);

        assertEquals("S1", userResult.getSurname());

    }

}