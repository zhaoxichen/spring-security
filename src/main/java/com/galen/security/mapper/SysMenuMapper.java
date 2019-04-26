package com.galen.security.mapper;

import com.galen.security.model.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * @Author: Galen
     * @Description: 更新父级id
     * @Date: 2019/4/25-12:07
     * @Param: [sysMenu]
     * @return: int
     **/
    int updateParentId(SysMenu sysMenu);

    /**
     * @Author: Galen
     * @Description: 获取当前系统权限菜单列表
     * @Date: 2019/4/20-12:03
     * @Param: [userId]
     * @return: java.util.List<com.apl.tl.model.SysMenu>
     **/
    List<SysMenu> getSysTreeMenuList(Long userId);

    /**
     * @Author: Galen
     * @Description: 获取当前系统权限菜单列表
     * @Date: 2019/4/20-12:03
     * @Param: [userId]
     * @return: java.util.List<com.apl.tl.model.SysMenu>
     **/
    List<SysMenu> getSysMenuList(Long userId);

    /**
     * @Author: Galen
     * @Description: 查询当前角色的权限
     * @Date: 2019/4/20-14:09
     * @Param: [roleId]
     * @return: java.util.List<com.apl.tl.model.SysMenu>
     **/
    List<SysMenu> getSysMenuListByRoleId(Long roleId);

    /**
     * @Author: Galen
     * @Description: 获取此用户的菜单id
     * @Date: 2019/4/24-16:31
     * @Param: [roleId]
     * @return: java.util.List<java.lang.Long>
     **/
    List<Long> getSysMenuIdListByRoleId(Long roleId);

    /**
     * @Author: Galen
     * @Description: 查询一批角色所拥有的权限id(去重复)
     * @Date: 2019/4/24-12:01
     * @Param: [roleList]
     * @return: java.util.List<java.lang.Long>
     **/
    List<Long> getSysMenuListByRoleIdList(@Param("roleList") List<Long> roleList);

}