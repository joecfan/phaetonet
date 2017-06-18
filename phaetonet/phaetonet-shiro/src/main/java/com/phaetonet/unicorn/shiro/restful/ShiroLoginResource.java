package com.phaetonet.unicorn.shiro.restful;

import com.phaetonet.unicorn.common.constant.ResultStatus;
import com.phaetonet.unicorn.common.model.ResultModel;
import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.manager.TokenManager;
import com.phaetonet.unicorn.shiro.model.TokenModel;
import com.phaetonet.unicorn.shiro.service.ShiroService;
import com.phaetonet.unicorn.shiro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultModel> login(@RequestBody User user) {
        logger.info("login..." + user.getUserCode());

        User u = shiroService.login(user);

        if (!u.isLogin()) {
            //提示用户名或密码错误
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }

        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(u.getId());

        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(value = "/403", method = RequestMethod.POST)
    public boolean unathorized() {
        System.out.println("403========================");
       return true;
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


    @RequestMapping("/403")
    public String unauthorizedRole(){
        logger.info("------没有权限-------");
        return "403";
    }

    @RequestMapping("/user")
    public String getUserList(Map<String, Object> model){

        return "user";
    }

    @RequestMapping("/user/edit/{userid}")
    public String getUserList(@PathVariable int userid){
        logger.info("------进入用户信息修改-------");
        return "user_edit";
    }
}
