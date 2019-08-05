package com.course.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.course.pojo.Notice;
import com.course.pojo.Userlogin;
import com.course.service.INoticeServie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private INoticeServie noticeService;

    @RequestMapping(value = "addNotice",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addNotice(Notice notice){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Userlogin user = (Userlogin) session.getAttribute("currUser");
        notice.setAuthorid(user.getUserid());
        JSONObject jsonObject = new JSONObject();
        boolean flag = noticeService.publish(notice);
        if(flag){
            jsonObject.put("res","发布成功");
        }else{
            jsonObject.put("res","发布失败");
        }
        return jsonObject.toJSONString();
    }



    @RequestMapping(value = "getNotice",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getNotice(){
        Notice notice = noticeService.getNotice();
        System.out.println(notice);
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(notice);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getAllNotice",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getAllNotice(){
        List<Notice> notice = noticeService.getAllNotice();
        System.out.println(notice);
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(notice);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
