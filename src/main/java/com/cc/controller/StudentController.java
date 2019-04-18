package com.cc.controller;

import com.cc.common.JsonBean;

import com.cc.common.JsonLayBean;
import com.cc.vo.VStaff;
import com.fasterxml.jackson.core.type.TypeReference;
import com.cc.entity.Student;
import com.cc.service.StudentService;
import com.cc.utils.ImportExcel;
import com.cc.utils.JsonUtils;
import com.cc.vo.VStudent;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/list.do")
    public Map<String, Object> stuAll(){
        List<VStudent> list = studentService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 10);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/student/delete.do")
    public JsonBean deleteByNo(String no) {
        studentService.deleteByNo(no);
       return JsonUtils.createJsonBean(1000,null);

    }

    @RequestMapping("/student/add.do")
    public void addStudent(Student student, HttpServletResponse response, HttpServletRequest request) throws IOException {
        student.setFlag(1);

        studentService.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/oa_student/studentlist.html");
    }

    @RequestMapping("/student/import.do")
    @ResponseBody
    public void importExcel(@RequestParam MultipartFile mFile ,HttpServletResponse response, HttpServletRequest request){


        try {
            String fileName = mFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = mFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

            // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
            ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(sourceList);

            // json字符串转对象
            List<Student> list = objMapper.readValue(infos, new TypeReference<List<Student>>() {});

            // 批量添加
            studentService.addStudentBatch(list);
            response.sendRedirect(request.getContextPath() + "/oa_student/studentlist.html");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }
    @RequestMapping("/student/studentpage.do")
    @ResponseBody
    public JsonLayBean listAll(int page, int limit) {

        List<VStudent> list = studentService.selectAllByPage((page - 1) * limit, limit);

        List<VStudent> list1 = studentService.findAll();
        return JsonUtils.createJsonBean(0, "", list1.size(), list);
    }

}
