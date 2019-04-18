package com.cc.service.impl;

import com.cc.dao.LoginlogMapper;
import com.cc.entity.Loginlog;
import com.cc.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginlogServiceImpl implements LoginlogService {

    @Autowired
    private LoginlogMapper loginlogDao;

    @Override
    public List<Loginlog> findAll() {
        return loginlogDao.selectAll();
    }

    @Override
    public int addlog(Loginlog loginlog) {
        return loginlogDao.insertSelective(loginlog);
    }
}
