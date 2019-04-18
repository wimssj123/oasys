package com.cc.dao;

import com.cc.entity.CourseType;

import java.util.List;

public interface CourseTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    CourseType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);
    //查询所有类型
    public List<CourseType> findAll();
}