package com.example.feign.Service.Impl;

import com.example.feign.Consumer.GetCall;
import com.example.feign.Consumer.GetHello;
import com.example.feign.Service.GetHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetHiImpl implements GetHi {
    @Autowired(required = false)
    private GetHello getHello;


    @Autowired
    private GetCall getCall;

    @Override
    public String consumer() {
        return getHello.sayHi();
    }

    @Override
    public String consumer2() {
        return getCall.callHi();
    }
}
