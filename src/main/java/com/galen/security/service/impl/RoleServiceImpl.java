package com.galen.security.service.impl;

import com.galen.security.mapper.SysRoleMapper;
import com.galen.security.mapper.SysUserMapper;
import com.galen.security.mapper.SysUserRoleMapper;
import com.galen.security.model.SysRole;
import com.galen.security.model.SysUserRole;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.RoleService;
import com.galen.security.utils.IdUtil;
import com.galen.security.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public GalenResponse createRole(SysRole sysRole) {
        sysRole.setId(IdUtil.generateNumberId());
        sysRoleMapper.insertSelective(sysRole);
        return ResponseUtils.SUCCESS();
    }

    @Override
    public GalenResponse addToRole(Long userId, Long roleId) {
        if (null == sysUserMapper.selectByPrimaryKey(userId)) {
            return ResponseUtils.build(501, "用户不存在");
        }
        if (null == sysRoleMapper.selectByPrimaryKey(roleId)) {
            return ResponseUtils.build(502, "角色不存在");
        }
        SysUserRole sysUserRole = sysUserRoleMapper.selectByUidRid(userId, roleId);
        if (null != sysUserRole) {
            return ResponseUtils.SUCCESS(sysUserRole.getId());
        }
        sysUserRole = new SysUserRole();
        sysUserRole.setId(IdUtil.generateNumberId());
        sysUserRole.setUserId(userId);
        sysUserRole.setRoleId(roleId);
        sysUserRoleMapper.insertSelective(sysUserRole);
        return ResponseUtils.SUCCESS(sysUserRole.getId());
    }
}
