package com.galen.security.service;

import com.galen.security.model.SysRole;

public interface RoleService {
    /**
     * @Author: Galen
     * @Description: 增加一个角色
     * @Date: 2019/3/22-9:12
     * @Param: [sysRole]
     * @return: java.lang.String
     **/
    String createRole(SysRole sysRole);

    /**
     * @Author: Galen
     * @Description: 添加用户为xxx角色
     * @Date: 2019/3/22-9:23
     * @Param: [userId, roleId]
     * @return: java.lang.String
     **/
    String addToRole(Long userId, Long roleId);
}
