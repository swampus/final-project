package com.groupj5.homework.auth;

import org.junit.Test;

import javax.crypto.Cipher;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CryptServiceTest {

    private CryptService cryptService = new CryptService();

    @Test
    public void encrypt() {
        assertEquals("abc__password", cryptService.encrypt("abc","password"));
    }

    @Test
    public void decrypt() {
        assertEquals("abc", cryptService.decrypt("abc__password","password"));
    }
}