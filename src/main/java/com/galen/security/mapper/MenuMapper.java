package com.galen.security.mapper;

import com.galen.security.model.SysPermission;
import com.galen.security.pojo.Menu;
import com.galen.security.pojo.SecurityPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Repository
public interface MenuMapper {
    /**
     * @Author: Galen
     * @Description: 获取所有的菜单
     * @Date: 2019/3/27-14:34
     * @Param: []
     * @return: java.util.List<Menu>
     **/
    List<Menu> getAllMenu();

    /**
     * @Author: Galen
     * @Description: 获取当前系统的所有权限
     * @Date: 2019/4/3-17:43
     * @Param: []
     * @return: java.util.List<com.galen.security.model.SecurityPermission>
     **/
    List<SecurityPermission> getPermissionAll();

}
