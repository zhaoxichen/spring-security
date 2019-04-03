package com.galen.security.service.impl;

import com.galen.security.mapper.SysRoleMapper;
import com.galen.security.mapper.SysUserRoleMapper;
import com.galen.security.model.SysRole;
import com.galen.security.model.SysUserRole;
import com.galen.security.service.RoleService;
import com.galen.security.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public String createRole(SysRole sysRole) {
        sysRole.setId(IdUtil.generateNumberId());
        sysRoleMapper.insertSelective(sysRole);
        return "success";
    }

    @Override
    public String addToRole(Long userId, Long roleId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(IdUtil.generateNumberId());
        sysUserRole.setUserId(userId);
        sysUserRole.setRoleId(roleId);
        sysUserRoleMapper.insertSelective(sysUserRole);
        return "success";
    }
}
