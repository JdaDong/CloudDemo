package com.example.ribbonthird;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
public class RibbonthirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonthirdApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        HystrixMetricsStreamServlet streamServlet= new HystrixMetricsStreamServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(streamServlet);
        bean.addUrlMappings("/hystrix.stream");
        bean.setLoadOnStartup(1);
        bean.setName("HystrixMetricsStreamServlet");
        return bean;
    }
}
