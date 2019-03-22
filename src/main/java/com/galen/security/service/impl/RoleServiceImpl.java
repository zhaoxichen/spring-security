package com.galen.security.service.impl;

import com.galen.security.mapper.SysRoleMapper;
import com.galen.security.mapper.SysRoleUsersMapper;
import com.galen.security.model.SysRole;
import com.galen.security.model.SysRoleUsers;
import com.galen.security.service.RoleService;
import com.galen.security.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleUsersMapper sysRoleUsersMapper;

    @Override
    public String createRole(SysRole sysRole) {
        sysRole.setId(IdUtil.generateNumberId());
        sysRoleMapper.insertSelective(sysRole);
        return "success";
    }

    @Override
    public String addToRole(Long userId, Long roleId) {
        SysRoleUsers sysRoleUsers = new SysRoleUsers();
        sysRoleUsers.setId(IdUtil.generateNumberId());
        sysRoleUsers.setUserId(userId);
        sysRoleUsers.setRoleId(roleId);
        sysRoleUsersMapper.insertSelective(sysRoleUsers);
        return "success";
    }
}
