package com.cc.service;

import com.cc.entity.Staff;
import com.cc.vo.VStaff;

import java.util.List;

public interface StaffService {

    public List<VStaff> selectAllByPage(int page,int limit);

    public void deleteByNo(String no);

    public int update(Staff staff);

    public String getLastNo();

    public void addStaff(Staff staff);

    public void addStaffBatch(List<Staff> list);

    public List<VStaff> listAll();
}


