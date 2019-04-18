package com.cc.controller;

import com.cc.common.JsonLayBean;
import com.cc.entity.Authority;
import com.cc.service.AuthorityService;
import com.cc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/authority/listall.do")
    public JsonLayBean listAll(){
        List<Authority> list = authorityService.findAll();

        return JsonUtils.createJsonBean(0,"",0,list);
    }



    @RequestMapping("/authority/authoritylist.do")
    public JsonLayBean findAllByPage(int page,int limit){
        List<Authority> list = authorityService.selectAllByPage((page-1)*limit,limit);
        List<Authority> list1 = authorityService.selectAll();
        return JsonUtils.createJsonBean(0,"",list1.size(),list);
    }


    @RequestMapping("/authority/delete.do")
    public JsonLayBean deleteById(int id){
       authorityService.deleteById(id);
        return JsonUtils.createJsonBean(1,"",0,null);
    }


    @RequestMapping("/authority/showroot.do")
    public JsonLayBean listRoot(){
        List<Authority> list = authorityService.findRoot();
        return JsonUtils.createJsonBean(1,"",list.size(),list);
    }



    @RequestMapping("/authority/add.do")
    public JsonLayBean addAuthority(Authority authority){
        int i = authorityService.insertAuth(authority);
        return JsonUtils.createJsonBean(1,"",i,null);
    }











}
