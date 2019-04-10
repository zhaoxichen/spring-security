package com.galen.security.service.impl;

import com.galen.security.model.SysPermission;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public GalenResponse createPermission(SysPermission sysPermission) {
        return null;
    }

    @Override
    public GalenResponse addToPermission(Long roleId, Long menuId) {
        return null;
    }
}
