package com.phaetonet.unicorn.shiro.restful;

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

    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        logger.info("login...");
        return shiroService.login(user);

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createUser(@RequestBody User user) {

        logger.info("createUser...");
        return shiroService.createUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {

        logger.info("updateUser...");
        return shiroService.updateUser(user);

    }
}
