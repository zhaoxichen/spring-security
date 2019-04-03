package com.galen.security.controller;

import com.galen.security.pojo.Menu;
import com.galen.security.pojo.RespBean;
import com.galen.security.service.MenuService;
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
    private MenuService menuService;

    @ApiOperation("增加权限")
    @PostMapping("create")
    public RespBean createPermission(Menu menu) {
        return menuService.createPermission(menu);
    }

    @ApiOperation("添加角色拥有xxx权限")
    @PostMapping("add/to")
    public RespBean addToPermission(Long roleId, Long menuId) {
        if (null == roleId || null == menuId) {
            return RespBean.error("错误");
        }
        return menuService.addToPermission(roleId, menuId);
    }

    @ApiOperation("查看权限列表")
    @GetMapping("list")
    public List<Menu> getList() {
        return menuService.getAllMenu();
    }
}
