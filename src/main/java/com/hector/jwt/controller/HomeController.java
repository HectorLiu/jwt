package com.hector.jwt.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @ResponseBody
    @GetMapping("/")
    @RequiresAuthentication
    public String index() {
        return "welcome index";
    }


}
