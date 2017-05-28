package com.phaetonet.unicorn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/26.
 */
@RestController
@RequestMapping("users")
public class LoginResource {

    private final static Logger logger = LoggerFactory.getLogger(LoginResource.class);

    @RequestMapping(value = "/tst")
    //public String login(@PathVariable String username) {
    public String login() {
        return "Welcome1112222211122222222222221111222222222222,";

    }
}
