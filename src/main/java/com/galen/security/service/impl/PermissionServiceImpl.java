package com.galen.security.service.impl;

import com.galen.security.mapper.SysPermissionMapper;
import com.galen.security.mapper.SysPermissionRoleMapper;
import com.galen.security.mapper.SysRoleMapper;
import com.galen.security.model.SysPermission;
import com.galen.security.model.SysPermissionRole;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.PermissionService;
import com.galen.security.utils.IdUtil;
import com.galen.security.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysPermissionRoleMapper sysPermissionRoleMapper;

    @Override
    public GalenResponse createPermission(SysPermission sysPermission) {
        sysPermission.setId(IdUtil.generateNumberId());
        sysPermissionMapper.insertSelective(sysPermission);
        return ResponseUtils.SUCCESS(sysPermission.getId());
    }

    @Override
    public GalenResponse addToPermission(Long roleId, Long permissionId) {
        if (null == sysRoleMapper.selectByPrimaryKey(roleId)) {
            return ResponseUtils.build(501, "角色不存在");
        }
        if (null == sysPermissionMapper.selectByPrimaryKey(permissionId)) {
            return ResponseUtils.build(502, "权限不存在");
        }
        SysPermissionRole sysPermissionRole = sysPermissionRoleMapper.selectByRidPid(roleId, permissionId);
        if (null != sysPermissionRole) {
            return ResponseUtils.SUCCESS(sysPermissionRole.getId());
        }
        sysPermissionRole = new SysPermissionRole();
        sysPermissionRole.setId(IdUtil.generateNumberId());
        sysPermissionRole.setRoleId(roleId);
        sysPermissionRole.setPermissionId(permissionId);
        sysPermissionRoleMapper.insertSelective(sysPermissionRole);
        return ResponseUtils.SUCCESS(sysPermissionRole.getId());
    }
}
