package com.galen.security.service.impl;

import com.galen.security.model.SysPermission;
import com.galen.security.pojo.RespBean;
import com.galen.security.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public RespBean createPermission(SysPermission sysPermission) {
        return null;
    }

    @Override
    public RespBean addToPermission(Long roleId, Long menuId) {
        return null;
    }
}
