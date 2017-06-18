package com.phaetonet.unicorn.shiro.service.impl;

import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.service.ShiroService;
import com.phaetonet.unicorn.shiro.service.UserService;
import com.phaetonet.unicorn.shiro.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/29.
 */

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private UserService userService;

    @Value("${shiro.key.md5}")
    private String shiroMD5Key;

    private final static Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    @Override
    public User login(User user) {
        Subject subject = SecurityUtils.getSubject();

        String password = CryptographyUtil.md5(user.getPassword(), shiroMD5Key);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserCode(), password);

        token.setRememberMe(user.getRemberMe());

        boolean isLogin = true;
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            isLogin = false;
            logger.error(e.getMessage());
        }
        User u = userService.updateUserLogin(user, isLogin);
        u.setPassword(null);
        u.setLogin(isLogin);

        return u;
    }

    @Override
    public boolean createUser(User user) {

        return userService.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {

        return userService.saveUser(user);
    }
}
