package com.galen.security.mapper;

import com.galen.security.model.SysPermissionRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermissionRole record);

    int insertSelective(SysPermissionRole record);

    SysPermissionRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermissionRole record);

    int updateByPrimaryKey(SysPermissionRole record);

    /**
     * @Author: Galen
     * @Description: 查看是否已经存在
     * @Date: 2019/4/12-16:01
     * @Param: [roleId, permissionId]
     * @return: com.galen.security.model.SysPermissionRole
     **/
    SysPermissionRole selectByRidPid(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
}