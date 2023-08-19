package com.example.cw2ind8.service;

import org.springframework.context.annotation.Bean;

import java.util.Random;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Random getRandom() {
        return  new Random();
    }
}
