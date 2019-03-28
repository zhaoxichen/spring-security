package com.galen.security.controller;

import com.galen.security.model.SysPermission;
import com.galen.security.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "权限controller", tags = {"权限操作接口"})
@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation("增加权限")
    @PostMapping("create")
    public String createPermission(SysPermission sysPermission) {
        return permissionService.createPermission(sysPermission);
    }

    @ApiOperation("添加角色拥有xxx权限")
    @PostMapping("add/to")
    public String addToPermission(Long roleId, Long permissionId) {
        if (null == roleId || null == permissionId) {
            return "error";
        }
        return permissionService.addToPermission(roleId, permissionId);
    }

    @ApiOperation("查看权限列表")
    @GetMapping("list")
    public List<SysPermission> getList() {
        return permissionService.getList();
    }
}
