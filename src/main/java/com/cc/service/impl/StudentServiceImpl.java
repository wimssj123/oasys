package com.cc.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.cc.dao.StudentMapper;

import com.cc.entity.Student;
import com.cc.service.StudentService;


import com.cc.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper stuDao;
    @Override
    public List<VStudent> findAll() {
        // TODO Auto-generated method stub
        return stuDao.findAll();
    }

    @Override
    public void deleteByNo(String no) {
        // TODO Auto-generated method stub
    stuDao.deleteByNo(no);
    }

    @Override
    public void addStudent(Student student){

      stuDao.insertSelective(student);
    }
    @Override
    public void addStudentBatch(List<Student> list) {
        int count = 1;
        List<Student> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                stuDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            stuDao.addBatch(tempList);
        }

    }

    @Override
    public List<VStudent> selectAllByPage(int page, int limit) {
        return stuDao.findAllByPage(page,limit);


    }
}
