package com.cc.service.impl;

import com.cc.dao.DepartmentMapper;
import com.cc.entity.Department;
import com.cc.service.DepartService;
import com.cc.vo.VDepart;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartmentMapper departDao;
    @Override
    public Map findAllDepart(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<VDepart> list = departDao.findAll();
        long total = ((Page) list).getTotal();
        Map<String,Object>  map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public List<VDepart> findAll() {
        return departDao.findAll();
    }

    @Override
    public void update(Department department) {
        departDao.updateByPrimaryKeySelective(department);
    }

    @Override
    public void deleteDepart(int id) {
        departDao.delete(id);
    }

    @Override
    public void add(Department department) {
        departDao.insertSelective(department);
    }
}
