package com.example.feign.Consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ribbon-provider2")
public interface GetCall {

    @RequestMapping(value = "/hello2/call",method = RequestMethod.GET)
    public String callHi();
}