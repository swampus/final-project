package com.groupj5.homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO extends AbstractResponseDTO {

    @JsonProperty("user_id")
    private Long id;
    private String name;
    private String surname;
    @JsonProperty("user_pk")
    private String userPk;
    private String email;
    private String address;
    private Integer status;
    @JsonProperty("user_hash")
    private String userHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserPk() {
        return userPk;
    }

    public void setUserPk(String userPk) {
        this.userPk = userPk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }
}
