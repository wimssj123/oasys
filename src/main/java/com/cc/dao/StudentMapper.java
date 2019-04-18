package com.cc.dao;


import com.cc.entity.Student;

import com.cc.vo.VStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    //查询所有学生
    public List<VStudent> findAll();
    //根据学号删除学生
    public void deleteByNo(String no);

    public void addBatch(List<Student> list);

    public List<VStudent> findAllByPage(@Param("page") int page, @Param("limit") int limit);

}