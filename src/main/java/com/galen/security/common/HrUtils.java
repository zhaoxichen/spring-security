package com.galen.security.common;

import com.galen.security.pojo.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
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
