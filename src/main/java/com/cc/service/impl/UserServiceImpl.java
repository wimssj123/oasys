package com.cc.service.impl;

import com.cc.dao.UserMapper;
import com.cc.entity.User;
import com.cc.service.UserService;
import com.cc.utils.SessionUtils;
import com.cc.vo.VUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;
    @Override
    public List<VUser> selectAllByPage(int page,int limit,String no,String flag) {
        return userDao.findAllByPage(page,limit,no,flag);
    }

    @Override
    public void deleteUser(int id) {

        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<VUser> selectAllManager(String name) {
        return userDao.findAllManage(name);
    }

    @Override
    public void update() {
        Session session =  SessionUtils.getSession();
        User user = (User) session.getAttribute(SessionUtils.LONG_USER);
        Subject subject = SecurityUtils.getSubject();
        user.setFlag(1);
        subject.logout();
        userDao.updateByPrimaryKeySelective(user);

    }

    @Override
    public List<VUser> listAll(String no, String flag) {
        return userDao.selectAll(no,flag);
    }

}


