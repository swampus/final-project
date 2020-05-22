package com.groupj7.homework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupj5.homework.database.NoSQLDatabaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfig {

    @Value("${property.environemt}")
    private String env;

}
