package com.groupj5.homework.service;

import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.dto.mapper.UserMapper;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import com.groupj5.homework.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {

        userValidator.checkNotAdmin(id);
        userValidator.checkNonUnlakcyUser(id);

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

    public UserDTO findByUserPersonalCode(String pk) {
        return userMapper.userToDto(userRepository.findOne(Example.of(User.from(pk))).orElseThrow(
                () -> new ServiceException(ErrorCode.GEN_USR_01,
                        ImmutableMap.of("pk", String.valueOf(pk)),
                        "en")));
    }

    public UserDTO findByUserPkAndStatus(String pk, Integer status) {



        User user = userRepository.findByUserPkAndStatus(pk, status);
        return userMapper.userToDto(user);
    }

}
