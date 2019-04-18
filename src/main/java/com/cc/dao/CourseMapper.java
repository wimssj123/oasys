package com.cc.dao;

import com.cc.entity.Course;
import com.cc.vo.VCourse;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    //查找count
    public int findCount();
    //查询所有
    public List<VCourse> findAll();
    //假删
    public void delete(int id);
}