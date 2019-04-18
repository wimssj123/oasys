package com.cc.service.impl;

import com.cc.dao.AuthorityMapper;
import com.cc.entity.Authority;
import com.cc.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityDao;

    @Override
    public List<Authority> findAll() {
        return authorityDao.selectAll();
    }

    @Override
    public List<Authority> selectAllByPage(int page,int limit) {
        return authorityDao.selectAllByPage(page,limit);
    }

    @Override
    public List<Authority> selectAll() {
        return authorityDao.selectAll();
    }

    @Override
    public void deleteById(int id) {
        authorityDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Authority> findRoot() {
        return authorityDao.findAll();
    }

    @Override
    public int insertAuth(Authority authority) {
        return authorityDao.insertSelective(authority);
    }


}
