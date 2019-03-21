package com.galen.security.mapper;

import com.galen.security.model.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}