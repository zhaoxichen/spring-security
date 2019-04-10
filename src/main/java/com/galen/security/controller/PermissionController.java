package com.galen.security.controller;

import com.galen.security.model.SysPermission;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.PermissionService;
import com.galen.security.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "权限controller", tags = {"权限操作接口"})
@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation("增加权限")
    @PostMapping("create")
    public GalenResponse createPermission(SysPermission sysPermission) {
        return permissionService.createPermission(sysPermission);
    }

    @ApiOperation("添加角色拥有xxx权限")
    @PostMapping("add/to")
    public GalenResponse addToPermission(Long roleId, Long menuId) {
        if (null == roleId || null == menuId) {
            return ResponseUtils.FAIL("错误");
        }
        return permissionService.addToPermission(roleId, menuId);
    }

}
