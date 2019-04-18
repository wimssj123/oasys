package com.cc.controller;

import com.cc.common.JsonLayBean;
import com.cc.entity.Check;
import com.cc.entity.Schedule;
import com.cc.entity.User;
import com.cc.service.CheckService;
import com.cc.service.ScheduleService;
import com.cc.utils.JsonUtils;
import com.cc.vo.VSchedule;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private CheckService checkService;
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/add.do")
    public JsonLayBean add(Check check) {


        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        check.setFlag(1);
        check.setStartno(user.getNo());
        check.setStartname(user.getName());
        int id = checkService.add(check);
        Schedule schedule = new Schedule();
        schedule.setCreatedate(new Date());
        schedule.setEnddate(check.getEnddate());
        schedule.setFlag(check.getFlag());
        schedule.setGid(id);
        schedule.setSno(user.getNo());
        schedule.setType(1);
        scheduleService.add(schedule);
        return JsonUtils.createJsonBean(0, "", 20,null);
    }
}
