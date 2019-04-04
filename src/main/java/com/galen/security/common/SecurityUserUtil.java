package com.galen.security.common;

import com.galen.security.pojo.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: Galen
 * @Date: 2019/4/4-9:38
 * @Description: 获取用户
 **/
public class SecurityUserUtil {
    /**
     * @Author: Galen
     * @Description: 从认证中心里面获取当前用户权限信息
     * @Date: 2019/3/28-9:49
     * @Param: []
     * @return: SecurityUser
     **/
    public static SecurityUser getCurrentHr() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
