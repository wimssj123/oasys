package com.cc.service;

import com.cc.entity.Grade;
import com.cc.vo.VGrade;

import java.util.List;

public interface GradeSevice  {
    public List<VGrade> findAll();

    public void DeleteById(Integer id);

    public void update(Grade grade);

    public void add(Grade grade);
}
