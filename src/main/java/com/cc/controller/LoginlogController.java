package com.cc.controller;

import com.cc.common.JsonLayBean;
import com.cc.entity.Loginlog;
import com.cc.service.LoginlogService;
import com.cc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loginlog")
public class LoginlogController {
    @Autowired
    private LoginlogService loginlogService;

    @RequestMapping("/findAll.do")
    public JsonLayBean findAll(){
        List<Loginlog> list = loginlogService.findAll();
        return JsonUtils.createJsonBean(0,"",20, list);
    }
}
