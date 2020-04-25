package com.groupj5.homework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupj5.homework.database.NoSQLDatabase;
import com.groupj5.homework.service.validator.TestValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfig {

    @Value("${property.environemt}")
    private String env;


    //@Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public NoSQLDatabase noSQLDatabase(){
        return new NoSQLDatabase();
    }

    @PostConstruct
    private void init() {
        System.out.println("\n \n \n ENV VAL " + env + "\n \n \n");
    }

}
