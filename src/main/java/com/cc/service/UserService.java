package com.cc.service;

import com.cc.vo.VUser;

import java.util.List;

public interface UserService {

    public List<VUser> selectAllByPage(int page,int limit,String no,String flag);

    public void deleteUser(int id);

    public List<VUser> selectAllManager(String name);

    //更新
    public void update();


    public List<VUser> listAll(String no,String flag);

}
