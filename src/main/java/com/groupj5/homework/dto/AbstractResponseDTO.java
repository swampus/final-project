package com.groupj5.homework.dto;

import java.util.Date;

public class AbstractResponseDTO {

    private String type = "Response";
    private Date time = new Date();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
