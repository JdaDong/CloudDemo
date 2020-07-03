package com.example.ribbon.Controller;

import com.example.ribbon.Service.HelloService;
import com.netflix.discovery.converters.Auto;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String sayHi(){
        return helloService.sayHello() +",hi,port" + port;
    }
}
