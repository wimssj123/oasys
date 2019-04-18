package com.cc.realm;

import com.cc.dao.LoginMapper;
import com.cc.dao.UserMapper;
import com.cc.entity.User;
import com.cc.utils.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.cc.utils.SessionUtils.LONG_USER;

public class MyRealm extends AuthorizingRealm {

     @Autowired
     private LoginMapper loginDao;

     @Autowired
     private UserMapper userDao;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取合法登录的用户的用户名
        String name = (String)principals.getPrimaryPrincipal();
        // 根据用户名从数据库查询用户的权限和角色
        List<String> roles = userDao.findRoleByName(name);
        List<String> perms = userDao.findPermisionByName(name);
        // 转为set集合对象
        Set<String> roleSet = new HashSet<>(roles);
        Set<String> permSet = new HashSet<>(perms);
        // 创建授权对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleSet);
        info.setStringPermissions(permSet);

        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取输入的用户名
        String name = (String)token.getPrincipal();
        // 根据用户名从数据库中查询密码
        User user =  loginDao.findUserByName(name);
        String passowrd = user.getPassword();
        SessionUtils.setSession(SecurityUtils.getSubject().getSession());
        Session session = SessionUtils.getSession();
        session.setAttribute(SessionUtils.LONG_USER,user);
        // 创建认证对象
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, passowrd, this.getName());
//
        return info;
    }
}
