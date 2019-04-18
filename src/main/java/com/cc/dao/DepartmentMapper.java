package com.cc.dao;

import com.cc.entity.Department;
import com.cc.vo.VDepart;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    //查询部门所有信息
    public List<VDepart> findAll();

    //删除部门
    public  void delete(int id);

}