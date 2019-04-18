package com.cc.service;

import com.cc.entity.User;

public interface LoginService {
    //登录
    public User login(String name, String password);
}
