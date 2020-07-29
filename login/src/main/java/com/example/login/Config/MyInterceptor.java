package com.example.login.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class MyInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(MyInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("prehandler" + handler.toString());
//        PrintWriter writer = response.getWriter();
//        writer.write("prehandler over");
//        writer.flush();
//        writer.close();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("posthandler" + handler.toString());
//        PrintWriter writer = response.getWriter();
//        writer.write("posthandler over");
//        writer.flush();
//        writer.close();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion" + handler.toString());
//        PrintWriter writer = response.getWriter();
//        writer.write("afterCompletion over");
//        writer.flush();
//        writer.close();
    }
}
