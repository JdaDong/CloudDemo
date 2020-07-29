package com.example.zuul.Utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.logging.Logger;

//过滤顺序 filter interceptor aop
//它们拦截的顺序
//Filter -> Interception -> AOP -> 具体执行的方法 -> AOP-> @ControllerAdvice 全局异常处理-> Interception-> Filter

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
