package com.example.feign.Config;

import com.example.feign.Consumer.GetHello;
import com.netflix.hystrix.Hystrix;
import org.springframework.stereotype.Component;

@Component
public class FirstHystrix implements GetHello {
    @Override
    public String sayHi() {
        return "sorry";
    }
}
