package com.galen.security.controller;

import com.galen.security.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sang on 2017/12/29.
 */
@Api(value = "登录", tags = "登录，注销等操作")
@RestController
public class LoginController {

    @ApiOperation(value = "swagger端测试登录入口")
    @PostMapping("/login")
    public RespBean login(String username, String password) {
        System.out.println(username + "------" + password);
        return RespBean.ok("登录成功!");
    }

    @ApiOperation(value = "swagger端测试注销入口")
    @PostMapping("/logout")
    public void logout() {
        System.out.println("注销成功!");
    }

    @ApiOperation(value = "提示跳转到登录页面")
    @GetMapping("/login_p")
    public RespBean loginP() {
        return RespBean.error("尚未登录，请登录!");
    }

    @ApiOperation(value = "普通用户登录成功后跳转的页面")
    @GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }

}
