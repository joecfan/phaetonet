package com.phaetonet.unicorn.shiro.service.impl;

import com.phaetonet.unicorn.shiro.dao.UserDao;
import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/28.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getByUserCode(String userCode) {
        return  userDao.getByUserCode(userCode);
    }

    @Override
    public User updateUserLogin(User user, boolean isSucess) {
         User existUser = userDao.getByUserCode(user.getUserCode());

         if (existUser != null) {
             if (!isSucess) {
                 existUser.setInvalidLogin(existUser.getInvalidLogin() + 1);
             }
             existUser.setUpdateTime(new Date());
         }

         return userDao.save(existUser);
    }

    @Override
    public boolean saveUser(User user) {
        boolean isSucess = false;
        User existUser = userDao.getByUserCode(user.getUserCode());

        if (existUser == null) {
            isSucess = true;
            user.setId(existUser.getId());
        }

        userDao.save(user);

        return isSucess;
    }


}
