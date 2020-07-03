package com.example.ribbon.Service.Impl;

import com.example.ribbon.Service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello() {
        return "hello";
    }

    @Value("${server.port}")
    String port;

    public String hiError(){
        return "hi error" + port;
    }
}
