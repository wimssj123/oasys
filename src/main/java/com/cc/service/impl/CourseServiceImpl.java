package com.cc.service.impl;

import com.cc.dao.CourseMapper;
import com.cc.entity.Course;
import com.cc.service.CourseService;
import com.cc.vo.VCourse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseDao;
    @Override
    public Map<String,Object> findAllCourse(int page, int limit) {

        PageHelper.startPage(page,limit);
        List<VCourse> list = courseDao.findAll();

        long total = ((Page)list).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("count",total);
        map.put("data",list);
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateByPrimaryKeySelective(course);

    }

    @Override
    public void add(Course course) {
        courseDao.insertSelective(course);
    }

    //假删
    @Override
    public void deleteCourse(int id) {
        courseDao.delete(id);
    }
//    @Override
//    public int searchCount() {
//        return courseDao.findCount();
//    }
}
