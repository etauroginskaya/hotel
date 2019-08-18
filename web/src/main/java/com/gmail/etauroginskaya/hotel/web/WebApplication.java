package com.gmail.etauroginskaya.hotel.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.gmail.etauroginskaya.hotel",
        exclude = UserDetailsServiceAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "com.gmail.etauroginskaya.hotel.repository")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}