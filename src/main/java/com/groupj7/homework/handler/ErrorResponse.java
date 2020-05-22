package com.groupj7.homework.handler;

import com.groupj7.homework.dto.AbstractResponseDTO;

import java.util.Map;

public class ErrorResponse extends AbstractResponseDTO {
    private ErrorCode errorCode;
    private String message;
    private Map<String, String> targetValue;
    private String lang;

    public ErrorResponse(ErrorCode errorCode, String message, Map<String, String> targetValue,
                         String lang) {
        this.errorCode = errorCode;
        this.message = message;
        this.targetValue = targetValue;
        this.lang = lang;
        this.setType("ERROR");
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Map<String, String> targetValue) {
        this.targetValue = targetValue;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
