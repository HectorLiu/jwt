package com.hector.jwt.shiro.core;

public class Authenticatable {

    public String getAuthIdentifierName() {
        return getKeyName();
    }

    public String getKeyName() {
        return "id";
    }
}
