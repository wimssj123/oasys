package com.cc.service;

import com.cc.entity.Loginlog;

import java.util.List;

public interface LoginlogService {
    public List<Loginlog> findAll();
    //添加
    public  int addlog(Loginlog loginlog);
}
