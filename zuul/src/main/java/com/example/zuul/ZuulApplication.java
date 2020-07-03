package com.example.zuul;

import com.example.zuul.Config.ZuulConfigImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public ZuulConfigImpl ZuulConfigImpl(){
        return new ZuulConfigImpl();
    }

//    @Bean
//    public PatternServiceRouteMapper patternServiceRouteMapper(){
//
//    }
}
