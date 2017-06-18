package com.phaetonet.unicorn.shiro.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_shiro_permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userCode", length = 20)
    private String userCode;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "permissionUrl", length = 200)
    private String permissionUrl;

    @Column(name = "method", length = 100)
    private String method;

    @Column(name = "description", length = 500)
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
        this.name = name;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name=" + name +
                ", permissionUrl=" + permissionUrl +
                ", method=" + method +
                ", description=" + description +
                '}';
    }
}