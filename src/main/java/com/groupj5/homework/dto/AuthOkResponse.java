package com.groupj5.homework.dto;

public class AuthOkResponse extends AbstractResponseDTO {
    private String secretContnet;

    public String getSecretContnet() {
        return secretContnet;
    }

    public void setSecretContnet(String secretContnet) {
        this.secretContnet = secretContnet;
    }
}
