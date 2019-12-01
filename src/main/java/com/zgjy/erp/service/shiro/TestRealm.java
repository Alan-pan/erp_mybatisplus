package com.zgjy.erp.service.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class TestRealm extends AuthorizingRealm {
    //用户授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //用户登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //传过来的是UsernamePasswordToken可以强制转换
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        //假设条件查询数据库 username对应的数据
        if ("null".equals(username)) {//假设为空对应的username
            throw new UnknownAccountException("用户不存在");
        }
        //还有其他异常可以查找。。。
        //通常返回对应是
        //以下是从数据库中获取
        //Object principal, 对应的实体信息,可以是username,也可以是对应的实体对象
        Object principal = "admin";
        //Object credentials, 数据库中的密码
        Object credentials = "admin";
        // String realmName 调用父类的getName
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, getName());
        return null;
    }
}
