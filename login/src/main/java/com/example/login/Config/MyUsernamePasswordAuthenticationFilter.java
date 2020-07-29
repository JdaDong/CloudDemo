package com.example.login.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(MyUsernamePasswordAuthenticationFilter.class.getName());

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("MyUsernamePasswordAuthenticationFilter enter");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("密码" + username+ ":" + password);
        return super.attemptAuthentication(request, response);
    }
}
