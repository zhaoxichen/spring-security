package com.galen.security.controller;

import com.galen.security.model.SysRole;
import com.galen.security.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "角色controller", tags = {"角色操作接口"})
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("增加角色")
    @PostMapping("create")
    public String createRole(SysRole sysRole) {
        return roleService.createRole(sysRole);
    }

    @ApiOperation("添加用户为xxx角色")
    @PostMapping("add/to")
    public String addToRole(Long userId, Long roleId) {
        if (null == userId || null == roleId) {
            return "error";
        }
        return roleService.addToRole(userId, roleId);
    }
}
