package com.galen.security.service;

import com.galen.security.model.SysPermission;

import java.util.List;

public interface PermissionService {
    /**
     * @Author: Galen
     * @Description: 增加权限
     * @Date: 2019/3/22-9:19
     * @Param: [sysPermission]
     * @return: java.lang.String
     **/
    String createPermission(SysPermission sysPermission);

    /**
     * @Author: Galen
     * @Description: 添加角色拥有xxx权限
     * @Date: 2019/3/22-9:27
     * @Param: [roleId, permissionId]
     * @return: java.lang.String
     **/
    String addToPermission(Long roleId, Long permissionId);

    /**
     * @Author: Galen
     * @Description: 查看权限列表
     * @Date: 2019/3/25-16:45
     * @Param: []
     * @return: java.util.List<com.galen.security.model.SysPermission>
     **/
    List<SysPermission> getList();
}
