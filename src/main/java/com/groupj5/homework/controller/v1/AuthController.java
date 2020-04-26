package com.groupj5.homework.controller.v1;

import com.groupj5.homework.dto.AuthPayloadDTO;
import com.groupj5.homework.service.UserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest/Auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/auth")
    public void auth(@RequestBody AuthPayloadDTO auth) {
        userService.userAuth(auth.getUserEmail(), auth.getPassword());
    }
}
