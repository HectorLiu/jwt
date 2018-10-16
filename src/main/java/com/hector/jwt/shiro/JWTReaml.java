package com.hector.jwt.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JWTReaml extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(JWTReaml.class);

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("JWTReaml doGetAuthorizationInfo");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("JWTReaml doGetAuthenticationInfo");
        return null;
    }
}
