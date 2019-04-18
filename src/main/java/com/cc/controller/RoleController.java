package com.cc.controller;


import com.cc.common.JsonLayBean;
import com.cc.entity.Role;
import com.cc.service.RoleService;
import com.cc.utils.JsonUtils;
import com.cc.vo.VMenuInfo;
import com.cc.vo.VRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ResponseBody
public class RoleController {
    @Autowired
    private RoleService roleService;

 @RequestMapping("/role/roleall.do")
    public JsonLayBean listRole(){
        List<Role> list = roleService.findAll();

        return JsonUtils.createJsonBean(0,"",0,list);


    }

    @RequestMapping("/role/userroleedit.do")
    public JsonLayBean roleEdit(int id, HttpServletRequest request){
        List<Role> list = roleService.findAll();
        String[] roles = request.getParameterValues("roles");
        roleService.update(id,roles);

        return JsonUtils.createJsonBean(1,"",0,list);


    }
    @RequestMapping("/menu/findAll.do")
    public JsonLayBean findMenu() {
        List<VMenuInfo> menu = roleService.findMenu();
        return JsonUtils.createJsonBean(0,"", 20, menu);
    }

    @RequestMapping("/role/list.do")
    public JsonLayBean listRole(String no){

        List<VRole> list = roleService.findByCondition(no);
        return JsonUtils.createJsonBean(0,"",list.size(),list);

    }

    @RequestMapping("/role/roledel.do")
    public JsonLayBean delRole(int id){
        roleService.delRole(id);
        return JsonUtils.createJsonBean(1,"",1,null);
    }

    @RequestMapping("/role/roleedit.do")
    public JsonLayBean editAuths(int id, HttpServletRequest request){
        List<Role> list = roleService.findAll();
        String[] auths = request.getParameterValues("roles");
        roleService.updateAuthority(id,auths);

        return JsonUtils.createJsonBean(1,"",0,list);


    }

}
