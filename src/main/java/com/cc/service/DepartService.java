package com.cc.service;

import com.cc.entity.Department;
import com.cc.vo.VDepart;

import java.util.List;
import java.util.Map;

public interface DepartService {
    //查询所有
    public Map findAllDepart(int page, int limit);

    public List<VDepart> findAll();
    //更新
    public void update(Department department);
    //删除
    public void deleteDepart(int id);
    //添加
    public void add(Department department);
}
