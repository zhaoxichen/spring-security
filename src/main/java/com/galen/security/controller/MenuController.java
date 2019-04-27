package com.galen.security.controller;

import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.MenuService;
import com.galen.security.utils.ResponseUtils;
import com.galen.security.utils.SecurityUserUtil;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "权限菜单controller", tags = {"权限菜单操作接口"})
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("获取当前用户的系统菜单")
    @GetMapping("/current/menu")
    public GalenResponse currentMenu() {
        return menuService.getMenusByUser();
    }

    @ApiOperation("获取当前用户的当前菜单页面的受限制按钮元素id集合")
    @GetMapping("/current/button")
    public GalenResponse currentButton(Long menuId) {
        if (null == menuId) {
            return ResponseUtils.build(401, "请传入菜单id");
        }
        return menuService.getButtonByUser(menuId);
    }

    @ApiOperation("获取当前用户")
    @GetMapping("/current/user")
    public GalenResponse currentUser() {
        /**
         * @Author: Galen
         * @Description: 获取request的其他信息
         **/
        return ResponseUtils.SUCCESS(SecurityUserUtil.getCurrentUser());
    }

    @ApiOperation("增加权限菜单（把资源加入权限管理）")
    @PostMapping("create")
    public GalenResponse createSysMenu(Integer menuType, Long parentId, String title, String titleEn, String iconPic, String path, String component,
                                       String elementId, String requestUrl, Integer sortOrder) {
        if (null == menuType) {
            return ResponseUtils.FAIL("请传入菜单类型：1：左侧主菜单；2：页面中的按钮；3：页面中标签");
        }
        if (null == parentId) {
            parentId = 0L;
        }
        if (StringUtil.isEmpty(title)) {
            if (1 == menuType) {
                return ResponseUtils.FAIL("请传入菜单名称");
            }
        }
        if (StringUtil.isEmpty(titleEn)) {
            if (1 == menuType) {
                return ResponseUtils.FAIL("请传入菜单英文名称");
            }
        }
        if (StringUtil.isEmpty(elementId)) {
            if (2 == menuType) {
                return ResponseUtils.FAIL("请传入元素id");
            }
        }
        if (StringUtil.isEmpty(requestUrl)) {
            requestUrl = "/";
        }
        if (null == sortOrder) {
            sortOrder = 1;
        }
        return menuService.createSysMenu(menuType, parentId, title, titleEn, iconPic, path, component, elementId, requestUrl, sortOrder);
    }

    @ApiOperation("更新权限菜单")
    @PostMapping("modify")
    public GalenResponse modifySysMenu(Long id, String title, String titleEn, String iconPic, String path, String component,
                                       String elementId, String requestUrl, Integer sortOrder) {
        if (null == id) {
            return ResponseUtils.FAIL("请传入权限菜单id");
        }
        return menuService.modifySysMenu(id, title, titleEn, iconPic, path, component, elementId, requestUrl, sortOrder);
    }

    @ApiOperation("添加角色拥有xxx权限")
    @PostMapping("add/to")
    public GalenResponse addToSysMenu(Long roleId, Long menuId) {
        if (null == roleId || null == menuId) {
            return ResponseUtils.build(401, "错误");
        }
        return menuService.addToSysMenu(roleId, menuId);
    }

    @ApiOperation(value = "查看系统权限资源管理", notes = "权限资源管理页面查看权限资源原始数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageBegin", value = "取第pageBegin页", dataType = "integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", dataType = "integer", paramType = "query", required = true)})
    @GetMapping("list/all/get")
    public GalenResponse getAllSysMenuList(@RequestParam(defaultValue = "1") Integer pageBegin,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        return menuService.getAllSysMenuList(pageBegin, pageSize);
    }

    @ApiOperation("查看系统权限资源")
    @GetMapping("list/get")
    public GalenResponse getSysMenuList(Long roleId) {
        if (null == roleId) {
            return menuService.getSysMenuList();
        }
        return menuService.getSysMenuList(roleId);
    }

    @ApiOperation("仅查看xx角色的权限资源列表")
    @GetMapping("list/role/get")
    public GalenResponse getRoleSysMenuList(Long roleId) {
        if (null == roleId) {
            return ResponseUtils.build(401, "错误");
        }
        return menuService.getRoleSysMenuList(roleId);
    }

    @ApiOperation(value = "移除xx角色的一个权限资源", notes = "业务上，权限取消勾选")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色编号", dataType = "long", paramType = "query", required = true),
            @ApiImplicitParam(name = "menuId", value = "菜单编号", dataType = "long", paramType = "query", required = true)})
    @PostMapping("/role/remove")
    public GalenResponse removeRoleSysMenu(Long roleId, Long menuId) {
        if (null == roleId || null == menuId) {
            return ResponseUtils.build(401, "错误");
        }
        return menuService.removeRoleSysMenu(roleId, menuId);
    }

    @ApiOperation("移除一个权限资源")
    @PostMapping("/remove")
    public GalenResponse removeSysMenu(Long menuId) {
        if (null == menuId) {
            return ResponseUtils.build(401, "错误");
        }
        return menuService.removeSysMenu(menuId);
    }


}
