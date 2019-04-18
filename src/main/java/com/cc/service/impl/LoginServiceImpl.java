package com.cc.service.impl;

import com.cc.dao.LoginMapper;
import com.cc.dao.UserMapper;
import com.cc.entity.User;
import com.cc.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userDao;
    @Autowired
    private LoginMapper loginDao;
    @Override
    public User login(String name, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        User user = loginDao.findUserByName(name);
        subject.login(token);
        //登陆过后改变状态
        user.setFlag(2);
        userDao.updateByPrimaryKeySelective(user);
        subject.getPrincipal();
        return user;
    }

}


















