package com.groupj5.homework.service;

import org.springframework.stereotype.Service;

@Service
public class InstagramService {
    public InstagramService() {
        //CONNECT TO SOME SERVER
        throw new RuntimeException("Connection failed");
    }

    public String returnResult(Long val){
        if(val == 5){
            return "OK";
        }
        return "NO";

    }
}
