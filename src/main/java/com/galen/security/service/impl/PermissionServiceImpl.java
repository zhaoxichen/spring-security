package com.galen.security.service.impl;

import com.galen.security.mapper.SysPermissionMapper;
import com.galen.security.mapper.SysRolePermissionMapper;
import com.galen.security.model.SysPermission;
import com.galen.security.model.SysRolePermission;
import com.galen.security.service.PermissionService;
import com.galen.security.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public String createPermission(SysPermission sysPermission) {
        sysPermission.setId(IdUtil.generateNumberId());
        sysPermissionMapper.insertSelective(sysPermission);
        return "success";
    }

    @Override
    public String addToPermission(Long roleId, Long permissionId) {
        SysRolePermission sysRolePermission = new SysRolePermission();
        sysRolePermission.setId(IdUtil.generateNumberId());
        sysRolePermission.setRoleId(roleId);
        sysRolePermission.setPermissionId(permissionId);
        sysRolePermissionMapper.insertSelective(sysRolePermission);
        return "success";
    }

    @Override
    public List<SysPermission> getList() {
        return sysPermissionMapper.findAll();
    }
}
