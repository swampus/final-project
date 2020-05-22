package com.groupj5.homework.service.validator;

import com.groupj5.homework.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestValidator {

    public void someting1(UserDTO userDTO) {
        userDTO.setUserPk("--");
        userDTO.setTime(new Date());
        //...
    }

    public void someting2(UserDTO userDTO) {
        userDTO.setUserPk("-");
        userDTO.setTime(new Date());
        //....
    }

}
