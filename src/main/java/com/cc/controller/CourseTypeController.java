package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.entity.CourseType;
import com.cc.service.CourseTypeService;
import com.cc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;
    @RequestMapping("/courseType/find.do")
    public JsonBean search(){
        List<CourseType> list = courseTypeService.searchAll();
        return JsonUtils.createJsonBean(1,list);
    }
}
