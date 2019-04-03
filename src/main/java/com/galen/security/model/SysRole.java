package com.galen.security.model;

import java.io.Serializable;

/**
 * 角色表
 * 
 * @author wcyong
 * 
 * @date 2019-04-03
 */
public class SysRole implements Serializable {
    private Long id;

    private String name;

    /**
     * 角色名称
     */
    private String namezh;

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

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh == null ? null : namezh.trim();
    }
}