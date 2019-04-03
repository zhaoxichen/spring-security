package com.galen.security.service;

import com.galen.security.pojo.Menu;
import com.galen.security.pojo.RespBean;

import java.util.List;


public interface MenuService {


    List<Menu> getAllMenu();

    /**
     * @Author: Galen
     * @Description: 添加权限菜单
     * @Date: 2019/4/2-14:25
     * @Param: [menu]
     * @return: com.galen.security.pojo.RespBean
     **/
    RespBean createPermission(Menu menu);

    /**
     * @Author: Galen
     * @Description: 给角色添加权限
     * @Date: 2019/4/2-14:26
     * @Param: [roleId, menuId]
     * @return: com.galen.security.pojo.RespBean
     **/
    RespBean addToPermission(Long roleId, Long menuId);
}
