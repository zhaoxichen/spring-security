package com.galen.security.controller;

import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.RoleService;
import com.galen.security.utils.ResponseUtils;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public GalenResponse createRole(String nameEn, String nameCn) {
        if (StringUtil.isEmpty(nameEn)) {
            return ResponseUtils.FAIL("请传入角色名");
        }
        if (StringUtil.isEmpty(nameCn)) {
            return ResponseUtils.FAIL("请传入角色别名，中文名");
        }
        return roleService.createRole(nameEn, nameCn);
    }

    @ApiOperation("修改角色属性")
    @PostMapping("modify")
    public GalenResponse modifyRole(Long roleId, String nameEn, String nameCn) {
        if (null == roleId) {
            return ResponseUtils.FAIL("请传入角色id");
        }
        if (StringUtil.isEmpty(nameEn)) {
            return ResponseUtils.FAIL("请传入角色名");
        }
        if (StringUtil.isEmpty(nameCn)) {
            return ResponseUtils.FAIL("请传入角色别名，中文名");
        }
        return roleService.modifyRole(roleId, nameEn, nameCn);
    }

    @ApiOperation("添加用户为xxx角色")
    @PostMapping("add/to")
    public GalenResponse addToRole(Long userId, Long roleId) {
        if (null == userId || null == roleId) {
            return ResponseUtils.build(401, "error");
        }
        return roleService.addToRole(userId, roleId);
    }

    @ApiOperation("查看所有系统角色（管理员才可以查看）")
    @GetMapping("list/all/get")
    public GalenResponse getAllSysRoleList() {
        return roleService.getAllSysRoleList();
    }

    @ApiOperation("查看系统角色，不包含独立角色（管理员才可以查看）")
    @GetMapping("list/get")
    public GalenResponse getSysRoleList(Long userId) {
        if (null == userId) {
            return roleService.getSysRoleList();
        }
        return roleService.getSysRoleList(userId);
    }

    @ApiOperation("查看xx用户的角色列表")
    @GetMapping("list/user/get")
    public GalenResponse getUserSysRoleList(Long userId) {
        if (null == userId) {
            return ResponseUtils.build(401, "错误");
        }
        return roleService.getUserSysRoleList(userId);
    }

    @ApiOperation("移除xx用户的一个角色")
    @PostMapping("/user/remove")
    public GalenResponse removeUserSysRole(Long userId, Long roleId) {
        if (null == userId || null == roleId) {
            return ResponseUtils.build(401, "错误");
        }
        return roleService.removeUserSysRole(userId, roleId);
    }

    @ApiOperation("移除一个角色")
    @PostMapping("/remove")
    public GalenResponse removeSysRole(Long roleId) {
        if (null == roleId) {
            return ResponseUtils.build(401, "错误");
        }
        return roleService.removeSysRole(roleId);
    }
}
