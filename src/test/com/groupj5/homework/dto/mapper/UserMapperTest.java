package com.groupj5.homework.dto.mapper;

import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.model.v1.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserMapperTest {

    private UserMapper userMapper = new UserMapper();

    @Test
    public void userToDto() {
        User user = new User();
        user.setId(1L);
        user.setAddress("Adddress");
        user.setEmail("email");
        user.setName("name");
        user.setStatus(0);
        user.setSurname("surname");
        user.setUserPk("userPk");

        UserDTO userDto = userMapper.userToDto(user);
        assertEquals("Adddress", userDto.getAddress());
        assertEquals("email", userDto.getEmail());
        assertEquals("name", userDto.getName());
        assertEquals("surname", userDto.getSurname());
        assertEquals("userPk", userDto.getUserPk());
        assertEquals(Long.valueOf(1), userDto.getId());


    }

    @Test
    public void fromDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setAddress("Adddress");
        userDTO.setEmail("email");
        userDTO.setName("name");
        userDTO.setStatus(0);
        userDTO.setSurname("surname");
        userDTO.setUserPk("userPk");

        User user = userMapper.fromDTO(userDTO);
        assertEquals("Adddress", user.getAddress());
        assertEquals("email", user.getEmail());
        assertEquals("name", user.getName());
        assertEquals("surname", user.getSurname());
        assertEquals("userPk", user.getUserPk());
        assertEquals(Long.valueOf(1), user.getId());


    }
}