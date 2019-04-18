package com.cc.service.impl;

import com.cc.dao.CourseTypeMapper;
import com.cc.entity.CourseType;
import com.cc.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeDao;
    @Override
    public List<CourseType> searchAll() {
        return courseTypeDao.findAll();
    }
}
