package com.groupj5.homework.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.groupj5.homework.dto.UserDTO;

@JsonRootName("")
public class UserCreateRequestDTO {
    @JsonProperty("user_dto")
    private UserDTO userDTO;
    @JsonProperty("password_hash")
    private String passHash;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
