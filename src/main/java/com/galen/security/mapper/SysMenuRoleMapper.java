package com.galen.security.mapper;

import com.galen.security.model.SysMenuRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenuRole record);

    int insertSelective(SysMenuRole record);

    /**
     * @Author: Galen
     * @Description: 批量插入权限关系
     * @Date: 2019/4/24-14:12
     * @Param: [sysMenuRoleList]
     * @return: int
     **/
    int insertList(@Param("sysMenuRoleList") List<SysMenuRole> sysMenuRoleList);

    SysMenuRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenuRole record);

    int updateByPrimaryKey(SysMenuRole record);

    SysMenuRole selectByMidPid(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    /**
     * @Author: Galen
     * @Description: 移除关联数据
     * @Date: 2019/4/20-14:19
     * @Param: [menuId]
     * @return: int
     **/
    int deleteByMenuId(Long menuId);

    /**
     * @Author: Galen
     * @Description: 同时删除此菜单的子菜单和角色的关联
     * @Date: 2019/4/24-17:03
     * @Param: [roleId, menuId]
     * @return: int
     **/
    int deleteByParentId(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    /**
     * @Author: Galen
     * @Description: 删除此角色与菜单的关联
     * @Date: 2019/4/25-11:41
     * @Param: [roleId]
     * @return: int
     **/
    int deleteByRoleId(Long roleId);
}