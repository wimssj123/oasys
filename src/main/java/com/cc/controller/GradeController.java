package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.common.JsonLayBean;
import com.cc.entity.Grade;
import com.cc.service.GradeSevice;
import com.cc.utils.JsonUtils;
import com.cc.vo.VGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeSevice gradeSevice;

    @RequestMapping("/findAll.do")
    public JsonLayBean findAll(int limit) {
        List<VGrade> list = gradeSevice.findAll();

        return JsonUtils.createJsonBean(0,"",limit, list);
    }
    @RequestMapping("/find.do")
    public List<VGrade> findAllGrade() {
        return gradeSevice.findAll();

    }
    @RequestMapping("/delete.do")
    public JsonLayBean delete(int id) {
        gradeSevice.DeleteById(id);
        return  JsonUtils.createJsonBean(0,"",10, null);
    }

    @RequestMapping("/update.do")
    public void update(Grade grade, HttpServletResponse response) {
        gradeSevice.update(grade);
        try {
            response.sendRedirect("../oa_grade/gradelist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/add.do")
    public JsonLayBean add(Grade grade) {
        gradeSevice.add(grade);
        return  JsonUtils.createJsonBean(0,"",10, null);
    }
}
