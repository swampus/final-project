package com.groupj5.homework.dto.mapper;


import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.model.v1.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setStatus(user.getStatus());
        userDTO.setSurname(user.getSurname());
        userDTO.setUserPk(user.getUserPk());
        return userDTO;
    }

    public UserDTO userToDto(User user, String hash) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setStatus(user.getStatus());
        userDTO.setSurname(user.getSurname());
        userDTO.setUserPk(user.getUserPk());
        userDTO.setUserHash(hash);
        return userDTO;
    }

    public User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setStatus(userDTO.getStatus());
        user.setSurname(userDTO.getSurname());
        user.setUserPk(userDTO.getUserPk());
        return user;
    }


}
