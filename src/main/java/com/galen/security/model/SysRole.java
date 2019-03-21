package com.galen.security.model;

/**
 * 角色表
 * 
 * @author wcyong
 * 
 * @date 2019-03-21
 */
public class SysRole {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}