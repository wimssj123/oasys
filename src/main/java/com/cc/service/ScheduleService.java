package com.cc.service;

import com.cc.entity.Schedule;
import com.cc.vo.VSchedule;

import java.util.List;

public interface ScheduleService {
    public List<VSchedule> findAllByNo(String no);

    public void deleteById(int id);

    public void add(Schedule schedule);
}
