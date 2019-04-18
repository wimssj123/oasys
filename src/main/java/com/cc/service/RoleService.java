package com.cc.service;

import com.cc.entity.Role;
import com.cc.vo.VMenuInfo;
import com.cc.vo.VRole;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();

    public void update(int uid,String[] roles);

    public List<VMenuInfo> findMenu();

    public List<VRole> findByCondition(String name);

    public void  delRole(int id);



    public void updateAuthority(int rid,String[] aid);
}


