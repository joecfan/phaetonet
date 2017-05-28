package com.phaetonet.unicorn.shiro.restful;

import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@RestController
@RequestMapping("shiro")
public class ShiroLoginResource {

    private final static Logger logger = LoggerFactory.getLogger(ShiroLoginResource.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserCode(), user.getPassword());
        token.setRememberMe(user.getRemberMe());

        boolean isSucess = true;
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            isSucess = false;
        }
        userService.updateUserLogin(user, isSucess);

        return isSucess;

    }
}
