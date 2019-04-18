package com.cc.service.impl;

import com.cc.dao.StaffMapper;
import com.cc.entity.Staff;
import com.cc.service.StaffService;
import com.cc.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffDao;
    @Override
    public List<VStaff> selectAllByPage(int page,int limit) {
        return staffDao.findAllByPage(page,limit);


    }

    @Override
    public void deleteByNo(String no) {
        staffDao.deleteByPrimaryKey(no);
    }

    @Override
    public int update(Staff staff) {

        return staffDao.updateByPrimaryKeySelective(staff);
    }

    @Override
    public String getLastNo() {
        return staffDao.getLastNo();
    }

    @Override
    public void addStaff(Staff staff) {
        staffDao.insertSelective(staff);
    }

    @Override
    public void addStaffBatch(List<Staff> list) {
        int count = 1;
        List<Staff> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                staffDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            staffDao.addBatch(tempList);
        }

    }

    @Override
    public List<VStaff> listAll() {
        return staffDao.selectAll();
    }
}
