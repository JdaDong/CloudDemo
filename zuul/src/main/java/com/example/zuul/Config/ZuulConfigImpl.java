package com.example.zuul.Config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.exception.ZuulException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZuulConfigImpl extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulConfigImpl.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("=================filter===============");
        return null;
    }
}
