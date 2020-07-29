package com.example.ribbon.Utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = Logger.getLogger(UserContextInterceptor.class.getName());

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        logger.info("enter");
        HttpHeaders headers = httpRequest.getHeaders();
        headers.add(UserContext.CORRELATION_ID, UserContextHolder.getUserContext().getCorrelationId());
        headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getUserContext().getAuthToken() );
        logger.info("over");
        return clientHttpRequestExecution.execute(httpRequest, bytes);

    }
}
