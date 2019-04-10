package com.galen.security.controller;

import com.galen.security.model.SysUser;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("create")
    public GalenResponse createUser(SysUser sysUser) {
        return userService.createUser(sysUser);
    }
}
