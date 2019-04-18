package com.cc.dao;

import com.cc.entity.Staff;
import com.cc.vo.VStaff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String no);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);


    public List<VStaff> findAllByPage(@Param("page") int page, @Param("limit") int limit);


    public String getLastNo();

    public void addBatch(List<Staff> list);

    public List<VStaff> selectAll();


}