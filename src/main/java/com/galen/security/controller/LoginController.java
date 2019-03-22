package com.galen.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登录controller", tags = {"登录操作接口"})
@RestController
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/admin")
    @ResponseBody
    public String hello() {
        return "hello admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        return "hello getList";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String save() {
        return "hello save";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String update() {
        return "hello update";
    }

}
