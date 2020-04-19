package com.groupj5.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfig {

    @Value("${property.environemt}")
    private String env;


    @PostConstruct
    private void init() {
        System.out.println("\n \n \n ENV VAL " + env + "\n \n \n");
    }

}
