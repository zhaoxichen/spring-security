package com.galen.security.service.impl;

import com.galen.security.mapper.SysPermissionMapper;
import com.galen.security.mapper.SysUserMapper;
import com.galen.security.model.SysPermission;
import com.galen.security.model.SysUser;
import com.galen.security.service.UserService;
import com.galen.security.utils.IdUtil;
import com.galen.security.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        if (sysUser != null) {
            List<SysPermission> permissions = sysPermissionMapper.findByAdminUserId(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    /**
                     * 此处将权限信息添加到 GrantedAuthority 对象中，
                     * 在后面进行全权限验证时会使用GrantedAuthority 对象。
                     */
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(sysUser.getUsername(), sysUser.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

    @Override
    public String createUser(SysUser sysUser) {
        if (null != sysUserMapper.selectByUsername(sysUser.getUsername())) {
            return "用户已经存在";
        }
        sysUser.setId(IdUtil.generateNumberId());
        sysUser.setPassword(MD5Util.encode(sysUser.getPassword()));
        sysUserMapper.insertSelective(sysUser);
        return "SUCCESS";
    }
}
