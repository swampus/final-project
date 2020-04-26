package com.groupj5.homework.handler;

public enum ErrorCode {


    GEN_ERR_01("Can not find data"),
    GEN_ERR_02("Can not insert user"),
    GEN_USR_01("User not found"),
    GEN_USR_13("User with ID 13 can not be search"),
    GEN_USR_20("Access Denied!");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
