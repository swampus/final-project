package com.groupj5.homework.auth;

import org.springframework.stereotype.Service;


@Service
public class CryptService {

    public static final String APP_KEY = "app_key";

    public String encrypt(String toEncrypt, String password) {
        return toEncrypt + "__" + password;
    }

    public String decrypt(String toDecrypt, String password) {
        return toDecrypt.replace("__" + password, "");
    }

}
