package com.groupj5.homework.service;

import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.dto.mapper.UserMapper;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.getOne(id);
        return userMapper.userToDto(user);
    }

    public void createUser(UserDTO userDTO){
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO){
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
    }

}
