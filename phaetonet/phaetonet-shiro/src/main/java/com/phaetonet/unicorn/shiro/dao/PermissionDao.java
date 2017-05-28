package com.phaetonet.unicorn.shiro.dao;

import com.phaetonet.unicorn.shiro.entity.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */
public interface PermissionDao extends CrudRepository<Permission, Long> {

    public List<Permission> getByUserCode(String userCode);
}
