package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.entity.Course;
import com.cc.service.CourseService;
import com.cc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/course/list.do")
    public Map findAll(int page,int limit){
        Map<String, Object> allCourse = courseService.findAllCourse(page, limit);
        return allCourse;
    }

    @RequestMapping("/course/update.do")
    public JsonBean updateCourse(Course course){
        courseService.updateCourse(course);
        return  JsonUtils.createJsonBean(1,null);
    }
    //添加课程
    @RequestMapping("/course/add.do")
    public JsonBean addCourse(Course course ,String date){
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
        Date createdate = null;
        try {
            Date newdate = adf.parse(date);
            createdate = newdate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        course.setCreatedate(createdate);
        course.setFlag(1);//1代表正常
        courseService.add(course);
        return  JsonUtils.createJsonBean(1,null);
    }

    //删除
    @RequestMapping("/course/delete.do")
    public JsonBean delete(int id){
        courseService.deleteCourse(id);
        return JsonUtils.createJsonBean(1000,null);
    }
}
