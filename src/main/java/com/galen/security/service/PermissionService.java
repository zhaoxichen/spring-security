package com.galen.security.service;

import com.galen.security.model.SysPermission;
import com.galen.security.pojo.RespBean;

public interface PermissionService {

    /**
     * @Author: Galen
     * @Description: 添加一个权限
     * @Date: 2019/4/4-9:25
     * @Param: [sysPermission]
     * @return: com.galen.security.pojo.RespBean
     **/
    RespBean createPermission(SysPermission sysPermission);

    /**
     * @Author: Galen
     * @Description: 给角色添加权限
     * @Date: 2019/4/2-14:26
     * @Param: [roleId, menuId]
     * @return: com.galen.security.pojo.RespBean
     **/
    RespBean addToPermission(Long roleId, Long menuId);
}
