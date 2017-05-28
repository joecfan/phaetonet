package com.phaetonet.unicorn.shiro.service;

import com.phaetonet.unicorn.shiro.entity.Permission;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */
public interface PermissionService {

    public List<Permission> getByUserCode(String userCode);
}
