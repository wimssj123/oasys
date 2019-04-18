package com.cc.service;



import com.cc.entity.Student;

import com.cc.vo.VStudent;

import java.util.List;

public interface StudentService {

    public List<VStudent> findAll();
    //删除
    public void deleteByNo(String no);
    //添加新学生
    public void addStudent(Student student);

    public void addStudentBatch(List<Student> list);

    public List<VStudent> selectAllByPage(int page,int limit);
}
