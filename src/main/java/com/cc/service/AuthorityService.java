package com.cc.service;

import com.cc.entity.Authority;

import java.util.List;

public interface AuthorityService {

    public List<Authority> findAll();

    public List<Authority> selectAllByPage(int page,int limit);

    public List<Authority> selectAll();

    public void deleteById(int id);

    public List<Authority> findRoot();

    public int insertAuth(Authority authority);
}

