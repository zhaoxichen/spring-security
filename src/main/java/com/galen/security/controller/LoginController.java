package com.galen.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(value = "登录controller", tags = {"登录操作接口"})
@RestController
@RequestMapping("/")
public class LoginController {

    @PostMapping("/admin")
    @ResponseBody
    public String hello() {
        return "hello admin";
    }

    @RequestMapping("/login")
    public String login(String username, String password) {
        return "login";
    }


}
