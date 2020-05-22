package com.groupj5.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthPayloadDTO {

    @JsonProperty("user_email")
    private String userEmail;

    private String password;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
