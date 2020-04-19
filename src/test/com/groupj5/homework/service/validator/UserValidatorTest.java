package com.groupj5.homework.service.validator;

import com.groupj5.homework.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator userValidator = new UserValidator();

    @Test
    void checkNotAdmin() {
        try{
            userValidator.checkNotAdmin(0L);
        }catch (ServiceException e){
            fail("Was catch, but should not");
        }

        try{
            userValidator.checkNotAdmin(1L);
            fail("Need to throw but not");
        }catch (ServiceException e){

        }
    }

    @Test
    void checkNonUnlakcyUser() {
        try{
            userValidator.checkNonUnlakcyUser(0L);
        }catch (ServiceException e){
            fail("Was catch, but should not");
        }

        try{
            userValidator.checkNonUnlakcyUser(13L);
            fail("Need to throw but not");
        }catch (ServiceException e){

        }
    }
}