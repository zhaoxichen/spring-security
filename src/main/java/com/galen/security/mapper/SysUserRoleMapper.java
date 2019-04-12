package com.galen.security.mapper;

import com.galen.security.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    /**
     * @Author: Galen
     * @Description: 查看是否已经存在
     * @Date: 2019/4/12-16:11
     * @Param: [userId, roleId]
     * @return: com.galen.security.model.SysUserRole
     **/
    SysUserRole selectByUidRid(@Param("userId") Long userId, @Param("roleId") Long roleId);
}