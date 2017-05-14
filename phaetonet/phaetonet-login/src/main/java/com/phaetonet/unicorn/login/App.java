package com.phaetonet.unicorn.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.phaetonet.unicorn.login.support.Appctx;
import com.phaetonet.unicorn.login.support.MyFilterSecurityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import security.entity.SysResource;
import security.service.SResourceService;
import csecurity.service.UserService;
import security.support.MySecurityFilter;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MyFilterSecurityInterceptor.class) //注意
/**
 * Hello world!
 *
 */
public class App 
{
    @Autowired
    private SResourceService sresourceService;

    private static final Logger log = LoggerFactory.getLogger(App.class);
    @PostConstruct
    public void initApplication() throws IOException {
        log.info("Running with Spring profile(s) : {}");
    }

    public static void main( String[] args )
    {
        //SpringApplication.run(MainApplication.class, args);
        SpringApplication app=new SpringApplication(App.class);
        Appctx.ctx=app.run(args);
        /*UserService suserService = (UserService) Appctx.ctx.getBean("suserService");
        SysUser su= suserService.findByName("user");
        System.out.println("密码"+su.getPassword());
        System.out.println("名字"+su.getName());
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密
        su.setPassword(bc.encode(su.getPassword()));
        System.out.println("密码"+su.getPassword());
        suserService.update(su);*/
    }
}
