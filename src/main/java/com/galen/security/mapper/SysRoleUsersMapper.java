package com.galen.security.mapper;

import com.galen.security.model.SysRoleUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleUsers record);

    int insertSelective(SysRoleUsers record);

    SysRoleUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleUsers record);

    int updateByPrimaryKey(SysRoleUsers record);
}