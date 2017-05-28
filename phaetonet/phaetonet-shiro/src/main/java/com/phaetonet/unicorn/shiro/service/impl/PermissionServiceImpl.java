package com.phaetonet.unicorn.shiro.service.impl;

import com.phaetonet.unicorn.shiro.dao.PermissionDao;
import com.phaetonet.unicorn.shiro.entity.Permission;
import com.phaetonet.unicorn.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getByUserCode(String userCode) {
        return permissionDao.getByUserCode(userCode);
    }
}
