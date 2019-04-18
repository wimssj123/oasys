package com.cc.service.impl;

import com.cc.dao.ScheduleMapper;
import com.cc.entity.Schedule;
import com.cc.service.ScheduleService;
import com.cc.vo.VSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<VSchedule> findAllByNo(String no) {

        return scheduleMapper.findAllByNo(no);
    }

    @Override
    public void deleteById(int id) {
        scheduleMapper.cancle(id);
    }

    @Override
    public void add(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }
}
