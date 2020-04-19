package com.groupj5.homework.service;

import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.dto.mapper.UserMapper;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
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

        if(id == 13){
            throw new ServiceException(ErrorCode.GEN_USR_13,
                    new HashMap<>(), "en");
        }

        try {
            User user = userRepository.getOne(id);
            return userMapper.userToDto(user);
        } catch (EntityNotFoundException e) {
            throw new ServiceException(ErrorCode.GEN_USR_01,
                    ImmutableMap.of("id", String.valueOf(id)),
                    "en");
        }


    }

    public void createUser(UserDTO userDTO) {
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO) {
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
    }

}
