package com.galen.security.model;

/**
 * 权限表
 * 
 * @author wcyong
 * 
 * @date 2019-03-21
 */
public class SysPermission {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * url前缀
     */
    private String url;

    /**
     * 方法
     */
    private String method;

    /**
     * 描述
     */
    private String description;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}