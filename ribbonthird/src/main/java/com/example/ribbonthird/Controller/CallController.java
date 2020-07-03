package com.example.ribbonthird.Controller;

import com.example.ribbonthird.Servce.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello2")
@RestController
public class CallController {
    @Autowired
    private CallService callService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/call")
    public String callHello(){
        return callService.callOnce() + "and port:" + port;
    }
}
