package com.example.feign.Service.Impl;

import com.example.feign.Consumer.GetCall;
import com.example.feign.Consumer.GetHello;
import com.example.feign.Service.GetHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetHiImpl implements GetHi {
    @Autowired(required = false)
    private GetHello getHello;


    @Autowired
    private GetCall getCall;


    @Transactional
    @Override
    public String consumer() {
        return getHello.sayHi();
    }

    @Transactional
    @Override
    public String consumer2() {
        return getCall.callHi();
    }
}
