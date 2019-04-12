package com.galen.security.controller;

import com.galen.security.model.SysRole;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.RoleService;
import com.galen.security.utils.ResponseUtils;
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
    public GalenResponse createRole(SysRole sysRole) {
        return roleService.createRole(sysRole);
    }

    @ApiOperation("添加用户为xxx角色")
    @PostMapping("add/to")
    public GalenResponse addToRole(Long userId, Long roleId) {
        if (null == userId || null == roleId) {
            return ResponseUtils.build(401, "error");
        }
        return roleService.addToRole(userId, roleId);
    }
}
