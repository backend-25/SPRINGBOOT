package com.example.Hello.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//3rd party call

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate CreateRestTemplate(){

        return new RestTemplate();
    }
}
