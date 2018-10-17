package com.hector.jwt.shiro.contract;

import javax.servlet.http.HttpServletRequest;

public interface Parser {
    String parse(HttpServletRequest request);
}
