package com.cc.dao;

import com.cc.entity.RoleAuthority;

public interface RoleAuthorityMapper {
    int deleteByPrimaryKey(RoleAuthority key);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);
}