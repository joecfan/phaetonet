package com.phaetonet.unicorn.shiro.service;

import com.phaetonet.unicorn.shiro.entity.User;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface ShiroService {

    public boolean login(User user);

    public boolean createUser(User user);

    public boolean updateUser(User user);
}
