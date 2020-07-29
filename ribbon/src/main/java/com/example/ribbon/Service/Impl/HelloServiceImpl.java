package com.example.ribbon.Service.Impl;

import com.example.ribbon.Service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloServiceImpl implements HelloService {
    @Transactional
    @HystrixCommand(fallbackMethod = "hiError",threadPoolKey = "helloThreadPool",
    threadPoolProperties = {
            @HystrixProperty(name="coreSize", value = "30")
    },
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")
    })
    public String sayHello() {
        return "hello";
    }

    @Value("${server.port}")
    String port;

    @Transactional
    public String hiError(){
        return "hi error" + port;
    }
}
