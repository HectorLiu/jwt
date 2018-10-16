package com.hector.jwt.shiro;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class JWTFilter extends AccessControlFilter{

    private final static Logger logger = LoggerFactory.getLogger(JWTFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        logger.info("JWTFilter isAccessAllowed");
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("JWTFilter onAccessDenied");
        return false;
    }
}
