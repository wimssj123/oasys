package com.cc.service;

import com.cc.entity.Course;

import java.util.Map;

public interface CourseService {
    public Map<String ,Object> findAllCourse(int page, int limit);
//    public int searchCount();
    //更新课程信息
    public void updateCourse(Course course);
    //添加课程信息
    public void add(Course course);
    //删除
    public void deleteCourse(int id);
}
