package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.mapper.StudentMapper;
import com.course.pojo.Student;
import com.course.pojo.StudentExample;
import com.course.pojo.Userlogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
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
        System.out.println("userlogin:"+userlogin);
        //当前subject
        Subject subject = SecurityUtils.getSubject();//Sbuject的实例通常是DelegatingSubject类
        if(!subject.isAuthenticated()){
            //shiro登录
            UsernamePasswordToken token =new UsernamePasswordToken(
                    userlogin.getUsername(),userlogin.getPassword());
            try {
                subject.login(token);
            }catch (UnknownAccountException unknownAccountEx){
                jsonObject.put("errorInfo","未知账户");
                unknownAccountEx.printStackTrace();
            }catch(IncorrectCredentialsException wrongPasswordEx){
                jsonObject.put("errorInfo","密码错误");
                wrongPasswordEx.printStackTrace();
            }catch(LockedAccountException lockedAccountEx){
                jsonObject.put("errorInfo","账户被锁定");
                lockedAccountEx.printStackTrace();
            } catch ( AuthenticationException ae ) {
                jsonObject.put("errorInfo","未知错误,请联系管理员");
                ae.printStackTrace();
            }

        }

        if(subject.hasRole("student")){
            System.out.println("您拥有角色 student");
        }else if(subject.hasRole("teacher")){
            System.out.println("您拥有角色 teacher");
        }else if(subject.hasRole("admin")){
            System.out.println("您拥有角色 admin");
        }

        jsonObject.put("url","index");
        return jsonObject.toJSONString();
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

}
