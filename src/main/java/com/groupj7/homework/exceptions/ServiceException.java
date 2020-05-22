package com.groupj7.homework.exceptions;

import com.groupj7.homework.handler.ErrorCode;

import java.util.Map;

public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;
    private String lang;
    private Map<String, String> targetParam;

    public ServiceException(ErrorCode errorCode, Map<String, String> targetParam, String lang) {
        this.errorCode = errorCode;
        this.lang = lang;
        this.targetParam = targetParam;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, String> getTargetParam() {
        return targetParam;
    }

    public void setTargetParam(Map<String, String> targetParam) {
        this.targetParam = targetParam;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
