package com.example.turbine;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {
    private Source source;

    public void push(){
        //source.output().send(MessageBuilder.withPayload())
    }
}
