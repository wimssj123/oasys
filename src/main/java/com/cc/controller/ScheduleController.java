package com.cc.controller;

import com.cc.common.JsonLayBean;
import com.cc.entity.Check;
import com.cc.entity.User;
import com.cc.service.ScheduleService;
import com.cc.utils.JsonUtils;
import com.cc.vo.VSchedule;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sche")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @RequestMapping("/findAll.do")
    public JsonLayBean findAll(int limit) {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        List<VSchedule> list = scheduleService.findAllByNo(user.getNo());
        return JsonUtils.createJsonBean(0, "", limit, list);
    }

    @RequestMapping("/cancle.do")
    public JsonLayBean cancle(int id){
        scheduleService.deleteById(id);
        return JsonUtils.createJsonBean(0, "", 20, null);
    }

}
