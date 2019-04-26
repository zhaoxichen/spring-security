package com.galen.security.service.impl;

import com.galen.security.mapper.SysMenuRoleMapper;
import com.galen.security.mapper.SysRoleMapper;
import com.galen.security.mapper.SysUserMapper;
import com.galen.security.mapper.SysUserRoleMapper;
import com.galen.security.model.SysRole;
import com.galen.security.model.SysUserRole;
import com.galen.security.pojo.GalenResponse;
import com.galen.security.pojo.SecuritySysUser;
import com.galen.security.service.RoleService;
import com.galen.security.utils.IdUtil;
import com.galen.security.utils.ResponseUtils;
import com.galen.security.utils.SecurityUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuRoleMapper sysMenuRoleMapper;

    @Override
    public GalenResponse createRole(String nameEn, String nameCn) {
        /**
         * @Author: Galen
         * @Description: 查看管理员的类型
         **/
        SecuritySysUser securitySysUser = SecurityUserUtil.getCurrentUser();
        if (null == securitySysUser) {
            return ResponseUtils.invalid();
        }
        /**
         * @Author: Galen
         * @Description: 查看角色是否已经存在
         **/
        SysRole sysRole = sysRoleMapper.selectByRoleName(nameEn);
        if (sysRole == null) {
            sysRole = new SysRole();
            sysRole.setId(IdUtil.generateNumberId());
            sysRole.setNameEn(nameEn);
            sysRole.setNameCn(nameCn);
            sysRole.setGroupType(securitySysUser.getUserType());
            sysRoleMapper.insertSelective(sysRole);
        }
        return ResponseUtils.SUCCESS(sysRole.getId());
    }

    @Override
    public GalenResponse modifyRole(Long roleId, String nameEn, String nameCn) {
        /**
         * @Author: Galen
         * @Description: 查看管理员的类型
         **/
        SecuritySysUser securitySysUser = SecurityUserUtil.getCurrentUser();
        if (null == securitySysUser) {
            return ResponseUtils.invalid();
        }
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (null == sysRole) {
            return ResponseUtils.build(501, "角色不存在！");
        }
        /**
         * @Author: Galen
         * @Description: 查看角色名是否已经存在
         **/
        SysRole sysRoleOfName = sysRoleMapper.selectByRoleName(nameEn);
        if (sysRoleOfName == null) {
            sysRole.setNameEn(nameEn);
            sysRole.setNameCn(nameCn);
            sysRoleMapper.updateByPrimaryKeySelective(sysRole);
            return ResponseUtils.SUCCESS(roleId);
        }
        /**
         * @Author: Galen
         * @Description: 角色名已经存在，判断是否是当前记录
         **/
        if (roleId.equals(sysRoleOfName.getId())) {
            sysRole.setNameCn(nameCn);
            sysRoleMapper.updateByPrimaryKeySelective(sysRole);
            return ResponseUtils.SUCCESS(roleId);
        }
        return ResponseUtils.build(502, "角色名已经存在！");
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

    @Override
    public GalenResponse getSysRoleList() {
        SecuritySysUser securitySysUser = SecurityUserUtil.getCurrentUser();
        if (null == securitySysUser) {
            return ResponseUtils.invalid();
        }
        if (0 == securitySysUser.getRoles().size()) {
            return ResponseUtils.build(501, "没有查看系统角色的权限");
        }
        if (1 != securitySysUser.getRoles().size() && !securitySysUser.getRoles().get(0).getOnAlone()) {
            return ResponseUtils.build(502, "不是独立权限的角色");
        }
        List<SysRole> sysRoleList = sysRoleMapper.getSysRoleList(securitySysUser.getRoles().get(0).getGroupType());
        return ResponseUtils.SUCCESS(sysRoleList);
    }

    @Override
    public GalenResponse getSysRoleList(Long userId) {
        SecuritySysUser securitySysUser = SecurityUserUtil.getCurrentUser();
        if (null == securitySysUser) {
            return ResponseUtils.invalid();
        }
        if (0 == securitySysUser.getRoles().size()) {
            return ResponseUtils.build(501, "没有查看系统角色的权限");
        }
        if (1 != securitySysUser.getRoles().size() && !securitySysUser.getRoles().get(0).getOnAlone()) {
            return ResponseUtils.build(502, "不是独立权限的角色");
        }
        List<Long> userRoleIdList = sysRoleMapper.getUserSysRoleIdList(userId);
        List<SysRole> sysRoleList = sysRoleMapper.getSysRoleList(securitySysUser.getRoles().get(0).getGroupType());
        for (SysRole sysRole : sysRoleList) {
            if (userRoleIdList.contains(sysRole.getId())) {
                sysRole.setOnChoose(true);
            } else {
                sysRole.setOnChoose(false);
            }
        }
        return ResponseUtils.SUCCESS(sysRoleList);
    }

    @Override
    public GalenResponse getUserSysRoleList(Long userId) {
        List<SysRole> sysRoleList = sysRoleMapper.getUserSysRoleList(userId);
        return ResponseUtils.SUCCESS(sysRoleList);
    }

    @Override
    public GalenResponse removeUserSysRole(Long userId, Long roleId) {
        SysUserRole sysUserRole = sysUserRoleMapper.selectByUidRid(userId, roleId);
        if (null != sysUserRole) {
            sysUserRoleMapper.deleteByPrimaryKey(sysUserRole.getId());
        }
        return ResponseUtils.SUCCESS("移除成功！");
    }

    @Override
    @Transactional
    public GalenResponse removeSysRole(Long roleId) {
        /**
         * @Author: Galen
         * @Description: 查看这个角色还有么有人在使用
         **/
        List<Long> userList = sysUserRoleMapper.selectUserByRid(roleId);
        if (null == userList || 0 != userList.size()) {
            return ResponseUtils.build(501, "存在用户正在关联此角色！");
        }
        /**
         * @Author: Galen
         * @Description: 删除此角色资源
         **/
        sysRoleMapper.deleteByPrimaryKey(roleId);
        /**
         * @Author: Galen
         * @Description: 删除此角色与用户的关联（防止存在脏数据）
         **/
        sysUserRoleMapper.deleteByRoleId(roleId);
        /**
         * @Author: Galen
         * @Description: 删除此角色与菜单的关联（防止存在脏数据）
         **/
        sysMenuRoleMapper.deleteByRoleId(roleId);
        return ResponseUtils.SUCCESS("移除成功！");
    }
}
