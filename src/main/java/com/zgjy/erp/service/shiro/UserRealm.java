package com.zgjy.erp.service.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.service.EmpService;
import com.zgjy.erp.service.MenuService;
import com.zgjy.erp.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    //授权角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前登录用户的用户名
        String username = (String)principals.getPrimaryPrincipal();
        //根据用户名查询当前用户拥有哪些角色
        Set<String> roles = roleService.queryRolesByUsername(username);
        //根据用户名查询当前用户拥有哪些权限
        Set<String> perms = menuService.queryPrivilegesByUsername(username);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }
    //认证账号
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username = (String) token.getPrincipal();
        //根据用户名获取用户信息
        Emp emp = empService.selectOne(new EntityWrapper<Emp>().eq("username",username));
        String password=null;
        if(emp == null) {
            throw new UnknownAccountException();//没找到帐号
        }else{
            password=emp.getPassword();
        }
        String salt="erp";
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(username+salt),getName());
        return info;
    }
}
