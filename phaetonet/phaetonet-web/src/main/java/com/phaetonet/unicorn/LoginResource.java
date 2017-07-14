package com.phaetonet.unicorn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@RestController
@CrossOrigin
@RequestMapping("users")
public class LoginResource {

    private final static Logger logger = LoggerFactory.getLogger(LoginResource.class);

    @RequestMapping(value = "/tst")
    //public String login(@PathVariable String username) {
    public String login() {
        return "Welcome1112222211122222222222221111222222222222,";

    }
}
