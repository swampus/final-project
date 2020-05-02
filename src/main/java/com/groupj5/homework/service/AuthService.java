package com.groupj5.homework.service;

import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.auth.CryptService;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String getUserPassword(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ServiceException(ErrorCode.GEN_USR_01, ImmutableMap.of("username", username), "en");
        }
        return user.getPassword();
    }

}
