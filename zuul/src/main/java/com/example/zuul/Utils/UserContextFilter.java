package com.example.zuul.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class UserContextFilter implements Filter {
    private static final Logger logger = Logger.getLogger(UserContextFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("enter");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        UserContextHolder.getUserContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
        UserContextHolder.getUserContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        UserContextHolder.getUserContext().setOrgId(httpServletRequest.getHeader(UserContext.ORG_ID));
        UserContextHolder.getUserContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
        filterChain.doFilter(httpServletRequest, servletResponse);
        logger.info("over");
    }
}
