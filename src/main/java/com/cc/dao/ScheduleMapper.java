package com.cc.dao;

import com.cc.entity.Schedule;
import com.cc.vo.VSchedule;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    public List<VSchedule> findAllByNo(String no);

    public void cancle(Integer id);


}