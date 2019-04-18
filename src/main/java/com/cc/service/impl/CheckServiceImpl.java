package com.cc.service.impl;

import com.cc.dao.CheckMapper;
import com.cc.entity.Check;
import com.cc.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckMapper checkMapper;
    @Override
    public int add(Check check) {
        return checkMapper.insert(check);
    }
}
