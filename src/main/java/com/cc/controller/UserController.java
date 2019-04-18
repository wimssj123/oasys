package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.common.JsonLayBean;
import com.cc.entity.User;
import com.cc.service.UserService;
import com.cc.utils.JsonUtils;
import com.cc.vo.VUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/userall.do")
    public JsonLayBean listAll(int page,int limit,String no,String flag){
//        int f = Integer.parseInt(flag);
        List<VUser> list = userService.selectAllByPage((page-1)*limit,limit,no,flag);

        List<VUser> list1 = userService.listAll(no, flag);
        return JsonUtils.createJsonBean(0,"",list1.size(),list);
    }

    @RequestMapping("/user/userdel.do")
    public JsonLayBean delete(int id){
        userService.deleteUser(id);
        return JsonUtils.createJsonBean(1,"",0,null);
    }

    @RequestMapping("/user/findManager.do")
    public JsonLayBean findManager() {
        List<VUser> list = userService.selectAllManager("manager");
        return JsonUtils.createJsonBean(0, "", 20, list);
    }

    @RequestMapping("/userloginout.do")
    public JsonBean logout(){
        userService.update();
        return  JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/user/findInfo.do")
    public JsonBean indInfo(){
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return  JsonUtils.createJsonBean(0,user);
    }
}
