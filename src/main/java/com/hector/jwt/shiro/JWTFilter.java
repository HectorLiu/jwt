package com.hector.jwt.shiro;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTFilter extends AccessControlFilter {

    private final static Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        // 在这里需要处理 1 ,当前URL是否需要token才能访问, 2 token是否正确
        logger.info("JWTFilter isAccessAllowed");
        if (isLoginAttempt(request, response)) {
            executeLogin(request, response);
        }
        return true;
    }

    private boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    private void executeLogin(ServletRequest request, ServletResponse response) {

        JWTToken token = new JWTToken("hector-token");
        getSubject(request, response).login(token);
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("JWTFilter onAccessDenied");
        return false;
    }
}
