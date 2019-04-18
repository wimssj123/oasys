package com.cc.service.impl;

import com.cc.dao.GradeMapper;
import com.cc.entity.Grade;
import com.cc.service.GradeSevice;
import com.cc.vo.VGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeSevice {
    @Autowired
    private GradeMapper gradeDao;

    @Override
    public List<VGrade> findAll() {

        return gradeDao.selectAll();
    }

    @Override
    public void DeleteById(Integer id) {

        gradeDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Grade grade) {
        gradeDao.updateByPrimaryKey(grade);
    }

    @Override
    public void add(Grade grade) {
        gradeDao.insert(grade);
    }
}
