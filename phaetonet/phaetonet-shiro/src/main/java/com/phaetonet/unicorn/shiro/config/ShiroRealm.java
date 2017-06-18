package com.phaetonet.unicorn.shiro.config;

import com.phaetonet.unicorn.shiro.entity.Permission;
import com.phaetonet.unicorn.shiro.entity.Role;
import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.service.PermissionService;
import com.phaetonet.unicorn.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cdyoue on 2016/10/21.
 */

public class ShiroRealm extends AuthorizingRealm {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        logger.info("doGetAuthorizationInfo：" + pc.toString());

        User user = userService.getByUserCode((String) pc.getPrimaryPrincipal());

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for(Role userRole : user.getRoles()){
            info.addRole(userRole.getName());
        }
        //赋予权限
        for(Permission permission : permissionService.getByUserCode(user.getUserCode())){
//            if(StringUtils.isNotBlank(permission.getPermCode()))
                info.addStringPermission(permission.getName());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo:"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();

        User user = userService.getByUserCode(token.getUsername());
        if (user != null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }

}
