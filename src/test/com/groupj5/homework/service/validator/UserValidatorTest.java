package com.groupj5.homework.service.validator;

import com.groupj5.homework.exceptions.ServiceException;
import org.junit.Test;

import static org.assertj.core.api.Fail.fail;

public class UserValidatorTest {

    private UserValidator userValidator = new UserValidator();

    @Test
    public void checkNotAdmin() {
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
    public void checkNonUnlakcyUser() {
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