package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.common.JsonLayBean;
import com.cc.entity.Department;
import com.cc.service.DepartService;
import com.cc.utils.JsonUtils;
import com.cc.vo.VDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
public class DepartController {
    @Autowired
    private DepartService departService;
    //列出所有部门
    @RequestMapping("/depart/list.do")
    public Map findAllByPage(int page,int limit){
        Map map = departService.findAllDepart(page, limit);
        return map;
    }

    @RequestMapping("/depart/list1.do")
    public JsonLayBean findAll(){
        List<VDepart> list = departService.findAll();
        return JsonUtils.createJsonBean(0,"",0,list);
    }
    //更新
    @RequestMapping("/depart/update.do")
    public JsonBean updateDepart(Department department,String date){
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        try {
            department.setCreatetime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        departService.update(department);
        return JsonUtils.createJsonBean(1,null);
    }

    //删除
    @RequestMapping("/depart/delete.do")
    public JsonBean delete(int id){
        departService.deleteDepart(id);
        return JsonUtils.createJsonBean(1000,null);
    }
    @RequestMapping("/depart/add.do")
    public JsonBean add(Department department,String date){
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        try {
            department.setCreatetime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        department.setFlag(1);
        departService.add(department);
        return JsonUtils.createJsonBean(1,null);
    }
}
