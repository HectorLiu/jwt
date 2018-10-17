package com.hector.jwt.shiro.core;

public interface UserProvider {

    Authenticatable retrieveById(Object identifier);
}
