package com.example.feign.Controller;

import com.example.feign.Service.GetHi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer")
@RestController
public class HelloController {
    @Autowired
    private GetHi getHi;

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/hi")
    public String hi(){
        return    getHi.consumer();
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/hi2")
    public String hi2(){
        return    getHi.consumer2();
    }

    public String error() {
        return "hello error!";
    }
}
