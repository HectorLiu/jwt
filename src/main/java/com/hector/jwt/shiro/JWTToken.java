package com.hector.jwt.shiro;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hector.jwt.shiro.contract.Parser;
import com.hector.jwt.shiro.core.AuthHaders;
import com.hector.jwt.shiro.core.Authenticatable;
import com.hector.jwt.shiro.core.UserProvider;
import com.hector.jwt.shiro.exception.JWTException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;
    private Authenticatable user;
    private HttpServletRequest request;

    @Autowired
    private UserProvider provider;

    private Parser parser;


    public JWTToken(HttpServletRequest request) {
        this.request = request;
    }

    public void init() {
        parser = new AuthHaders();
        if (token == null || token.isEmpty()) {
            token = parseToken(request);
        }
    }


    private String parseToken(HttpServletRequest request) {
        String token = parser.parse(request);
        if (token.isEmpty()) {
            throw new UnauthenticatedException("invalid token");
        }
        return token;
    }

    @Override
    public Object getPrincipal() {
        if (user != null) {
            return user;
        }
        String payload = JWTUtil.getPayload(token);
        return user = provider.retrieveById(payload);
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
