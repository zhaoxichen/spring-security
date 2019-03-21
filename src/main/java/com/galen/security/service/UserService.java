package com.galen.security.service;

import com.galen.security.model.SysUser;

public interface UserService {
    /**
     * @Author: Galen
     * @Description: 添加用户
     * @Date: 2019/3/21-17:34
     * @Param: [sysUser]
     * @return: java.lang.String
     **/
    String createUser(SysUser sysUser);
}
