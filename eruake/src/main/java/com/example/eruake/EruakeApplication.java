package com.example.eruake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EruakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EruakeApplication.class, args);
    }

}
