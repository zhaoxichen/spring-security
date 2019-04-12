package com.galen.security.service;

import com.galen.security.model.SysRole;
import com.galen.security.pojo.GalenResponse;

public interface RoleService {
    /**
     * @Author: Galen
     * @Description: 增加一个角色
     * @Date: 2019/3/22-9:12
     * @Param: [sysRole]
     * @return: com.galen.security.pojo.GalenResponse
     **/
    GalenResponse createRole(SysRole sysRole);

    /**
     * @Author: Galen
     * @Description: 添加用户为xxx角色
     * @Date: 2019/4/12-17:52
     * @Param: [userId, roleId]
     * @return: com.galen.security.pojo.GalenResponse
     **/
    GalenResponse addToRole(Long userId, Long roleId);
}
