package com.galen.security.mapper;

import com.galen.security.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    /**
     * @Author: Galen
     * @Description: 根据角色名称获取
     * @Date: 2019/4/9-17:41
     * @Param: [role_supplier]
     * @return: com.apl.pgs.mini.model.SysRole
     **/
    SysRole selectByRoleName(String roleName);

    /**
     * @Author: Galen
     * @Description: 获取此管理员的所有的系统的角色
     * @Date: 2019/4/24-9:37
     * @Param: [getGroupType]
     * @return: java.util.List<com.apl.tl.model.SysRole>
     **/
    List<SysRole> getAllSysRoleList(Integer getGroupType);

    /**
     * @Author: Galen
     * @Description: 获取此管理员的系统的角色(不包括独立角色)
     * @Date: 2019/4/24-9:37
     * @Param: [getGroupType]
     * @return: java.util.List<com.apl.tl.model.SysRole>
     **/
    List<SysRole> getSysRoleList(Integer getGroupType);

    /**
     * @Author: Galen
     * @Description: 获取指定用户的角色列表
     * @Date: 2019/4/20-14:37
     * @Param: [userId]
     * @return: java.util.List<com.apl.tl.model.SysRole>
     **/
    List<SysRole> getUserSysRoleList(Long userId);

    /**
     * @Author: Galen
     * @Description: 获取指定用户的角色id列表
     * @Date: 2019/4/24-14:53
     * @Param: [userId]
     * @return: java.util.List<java.lang.Long>
     **/
    List<Long> getUserSysRoleIdList(Long userId);
}