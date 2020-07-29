package com.example.login;

import com.thoughtworks.xstream.converters.collections.BitSetConverter;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.concurrent.BlockingQueue;

@RestController
public class LogoutController {

    private Logger logger = LoggerFactory.getLogger(LogoutController.class.getName());

    @RequestMapping("/logout")
    public void logout(){
        logger.info("logout");
    }

    @RequestMapping("/hello")
    public void hello(){
        logger.info("hello");
    }

    @RequestMapping("/Hello")
    private String Hello(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double money = 2.42425;
        String res = decimalFormat.format(money);
        return "Hello" + res;
    }

//    @RequestMapping("/Helloo")
//    private String Helloo(){
//        return "Helloo";
//    }



}
