package com.cc.dao;

import com.cc.entity.Role;
import com.cc.vo.VMenuInfo;
import com.cc.vo.VRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


    public List<Role> findAll();

    public void deleteByUid(int uid);

    public void insertByUidRid(@Param("uid") int uid, @Param("rid") int rid);

    public List<VMenuInfo> findMenu(List<Integer> ids);

    public List<VRole> findAllByCondition(@Param("name") String name);

    // 清除角色对应的权限
    public void deleteByRid(int rid);

    // 添加角色的权限
    public void insertByRidAid(@Param("rid") int rid, @Param("aid") int aid);




}