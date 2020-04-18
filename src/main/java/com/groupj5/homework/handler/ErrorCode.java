package com.groupj5.homework.handler;

public enum ErrorCode {


    GEN_ERR_01("Can not find data"),
    GEN_ERR_02("Can not insert user");

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
