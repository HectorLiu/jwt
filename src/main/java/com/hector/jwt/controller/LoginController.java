package com.hector.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.hector.jwt.annotation.CurrentUser;
import com.hector.jwt.base.Responder;
import com.hector.jwt.base.Result;
import com.hector.jwt.model.User;
import com.hector.jwt.shiro.JWTUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/api/login")
    public Result<Map<String, Object>> index(@RequestBody JSONObject requestJson) {
        String username = requestJson.getString("username");
        String password = requestJson.getString("password");

        Map<String, Object> result = new HashMap<>();
        result.put("access_token", JWTUtil.sign(username, password));

        return Responder.responseData(result);
    }


    @ResponseBody
    @GetMapping("/api/me")
    public Result<User> me(@CurrentUser User user){
       return Responder.responseData(user);
    }
}
