package com.galen.security.service;

import com.galen.security.model.SysUser;
import com.galen.security.pojo.GalenResponse;

public interface UserService {
    /**
     * @Author: Galen
     * @Description: 添加用户
     * @Date: 2019/4/10-9:26
     * @Param: [sysUser]
     * @return: com.galen.security.pojo.GalenResponse
     **/
    GalenResponse createUser(SysUser sysUser);
}
