package com.cc.dao;

import com.cc.entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    // 查询一级权限
    public List<Authority> findAll();
    // 查询所有权限
    public List<Authority> selectAllByPage(@Param("page") int page,@Param("limit") int limit);

    public List<Authority> selectAll();



}