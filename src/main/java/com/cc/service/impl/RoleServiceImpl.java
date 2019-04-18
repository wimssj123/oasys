package com.cc.service.impl;

import com.cc.dao.RoleMapper;
import com.cc.dao.UserMapper;
import com.cc.entity.Role;
import com.cc.entity.User;
import com.cc.service.RoleService;
import com.cc.vo.VMenuInfo;
import com.cc.vo.VRole;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleDao;
    @Autowired
    private UserMapper userDao;
    @Override
    public List<Role> findAll() {

        return roleDao.findAll();
    }

    @Override
    public void update(int uid, String[] roles) {
        roleDao.deleteByUid(uid);

        if(roles == null || roles.length == 0){
            return;
        }
        for (int i=0; i <roles.length; i++){
            int rid = Integer.parseInt(roles[i]);
            roleDao.insertByUidRid(uid,rid);
        }
    }

    @Override
    public List<VMenuInfo> findMenu() {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        List<Role> list = userDao.findRoleById(user.getId());
        List<Integer> ids = new ArrayList<>();
        for(Role role : list){
            ids.add(role.getId());
        }

        return roleDao.findMenu(ids);
    }

    @Override
    public List<VRole> findByCondition(String name) {
        return roleDao.findAllByCondition(name);
    }

    @Override
    public void delRole(int id) {
        roleDao.deleteByPrimaryKey(id);
    }


    @Override
    public void updateAuthority(int rid, String[] aid) {
        roleDao.deleteByRid(rid);

        if(aid == null || aid.length ==0){
            return;
        }

        for (int i=0; i <aid.length; i++){
            int aid1 = Integer.parseInt(aid[i]);
            roleDao.insertByRidAid(rid,aid1);
        }

    }
}
