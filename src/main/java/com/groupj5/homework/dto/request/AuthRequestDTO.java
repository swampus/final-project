package com.groupj5.homework.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequestDTO {

    private String username;

    @JsonProperty("crypted_token")
    private String cryptedToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCryptedToken() {
        return cryptedToken;
    }

    public void setCryptedToken(String cryptedToken) {
        this.cryptedToken = cryptedToken;
    }
}
