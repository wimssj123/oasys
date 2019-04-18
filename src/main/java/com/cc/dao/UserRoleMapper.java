package com.cc.dao;

import com.cc.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);
}