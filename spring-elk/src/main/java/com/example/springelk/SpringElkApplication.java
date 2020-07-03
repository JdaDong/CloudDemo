package com.example.springelk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringElkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringElkApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {

    }
}
