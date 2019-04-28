package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.mapper.StudentMapper;
import com.course.pojo.Student;
import com.course.pojo.StudentExample;
import com.course.pojo.Userlogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

@Controller
public class LoginController {



    @RequestMapping(value = "/logon",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(Userlogin userlogin){
        JSONObject jsonObject = new JSONObject();

        System.out.println(userlogin);
        //当前subject
        Subject subject = SecurityUtils.getSubject();//Sbuject的实例通常是DelegatingSubject类

        try {
            if(!subject.isAuthenticated()){
                //shiro登录
                UsernamePasswordToken token =new UsernamePasswordToken(
                        userlogin.getUsername(),userlogin.getPassword());
                subject.login(token);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("errorInfo","用户不存在或密码错误！请检查后重新输入");
            return jsonObject.toJSONString();
        }


        if(subject.hasRole("student")){
            System.out.println("您拥有角色 student");
            jsonObject.put("url","index");
            return jsonObject.toJSONString();
        }
        jsonObject.put("errorInfo","error");
        return jsonObject.toJSONString();
    }

}
