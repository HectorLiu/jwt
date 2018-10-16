package com.hector.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @ResponseBody
    @GetMapping("/login")
    public String index() {
        return "please login";
    }
}
