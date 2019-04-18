package com.cc.controller;

import com.cc.common.JsonBean;
import com.cc.common.JsonIp;
import com.cc.entity.Loginlog;
import com.cc.entity.User;
import com.cc.service.LoginService;
import com.cc.service.LoginlogService;
import com.cc.utils.IpUtils;
import com.cc.utils.JsonUtils;
import com.cc.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private LoginlogService loginlogService;
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login.do")
    public JsonBean login(String name, String password,String ip){
        JsonIp info = null;
        String location = null;
        IpUtils ipUtils = new IpUtils();
        Loginlog loginlog = new Loginlog();
        Date date = new Date();
        String mdPassword = MD5Utils.md5(password);
        try {
            User user = loginService.login(name, mdPassword);
            try {
                info = ipUtils.getAddresses("ip="+ip, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (info.getCode() == 0) {
                String city = info.getData().getCity();
                String region =   info.getData().getRegion();
                location = region+"省"+city+"市";
                loginlog.setCreatetime(date);
                loginlog.setIp(ip);
                loginlog.setLocation(location);
                loginlog.setNo(name);
                loginlogService.addlog(loginlog);
            } else if(info.getCode()==1){
                location = "内网访问";
            }else{
                location = "访问错误";
            }
//            session.setAttribute("user",user);
            return  JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return  JsonUtils.createJsonBean(0,e.getMessage());
        }
    }
}











