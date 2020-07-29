package com.example.login;

import com.example.login.Config.MyWebmvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.DispatcherServlet;

@EnableDiscoveryClient
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

//    @Bean
//    public MyWebmvcConfig webmvcConfig(){
//        return new MyWebmvcConfig();
//    }

//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean reg = new ServletRegistrationBean(dispatcherServlet);
//     //   reg.getUrlMappings().clear();
//     //   reg.addUrlMappings("/Helloo");
//        reg.addUrlMappings("*.html");
//        reg.addUrlMappings("*.do");
//        return reg;
//    }

}
