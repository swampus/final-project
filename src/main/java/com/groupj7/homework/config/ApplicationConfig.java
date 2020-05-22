package com.groupj7.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${property.environemt}")
    private String env;

}
