package com.hector.jwt.shiro.core;

import com.hector.jwt.shiro.contract.Parser;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthHaders implements Parser {

    private static final String auth = "authorization";
    private static final String prefix = "bearer";

    @Override
    public String parse(HttpServletRequest request) {
        String header = request.getHeader(auth);
        String pattern = "/" + prefix + "\\s*(\\S+)\\b/i";

        if (header == null || header.isEmpty()) {
            return "";
        }
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(header);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }
}
