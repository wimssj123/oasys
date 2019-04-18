package com.cc.dao;

import com.cc.entity.User;

import java.util.List;

//登录
public interface LoginMapper {
  //根据用户名找密码
    public User findUserByName(String name);
    //找角色
    public List<String> findRoleByName(String name);
    //找权限
    public List<String> findPermissionByName(String name);

}
