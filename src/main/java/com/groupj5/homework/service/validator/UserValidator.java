package com.groupj5.homework.service.validator;

import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UserValidator {

    public void checkNotAdmin(Long id) {
        if (id == 1) {
            throw new ServiceException(ErrorCode.GEN_USR_01,
                    ImmutableMap.of("id", String.valueOf(id)),
                    "en");
        }
    }

    public void checkNonUnlakcyUser(Long id) {
        if (id == 13) {
            throw new ServiceException(ErrorCode.GEN_USR_13,
                    new HashMap<>(), "en");
        }
    }
}
