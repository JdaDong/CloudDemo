package com.example.ribbonthird.Servce.Impl;

import com.example.ribbonthird.Servce.CallService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CallServiceImpl implements CallService {
    @Override
    @Transactional
    @HystrixCommand(fallbackMethod = "hiError")
    public String callOnce() {
        return "call";
    }

    @Value("${server.port}")
    String port;

    @Transactional
    public String hiError(){
        return "hi error" + port;
    }
}
