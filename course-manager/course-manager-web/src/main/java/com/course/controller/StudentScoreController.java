package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.pojo.StudentCourse;
import com.course.pojo.StudentCourse1;
import com.course.pojo.Userlogin;
import com.course.service.impl.StudentCourseService;
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
@RequestMapping("score")
public class StudentScoreController {

    @Autowired
    private StudentCourseService studentCourseService;
    //
    @RequestMapping(value = "getScore", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getScore() {
        ObjectMapper objectMapper = new ObjectMapper();

        String result = "";

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Userlogin user = (Userlogin) session.getAttribute("currUser");
        int tid = user.getUserid();
        List<StudentCourse1> studentCourse = studentCourseService.getAllScore(tid);

        try {
            result = objectMapper.writeValueAsString(studentCourse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }


    @RequestMapping(value = "updateScore", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateScore(StudentCourse studentCourse) {
        System.out.println(studentCourse.getStudentid()+"--"+studentCourse.getCourseid()+"--"+studentCourse.getScore());
        JSONObject jsonObject = new JSONObject();
        boolean rest = studentCourseService.updateScore(studentCourse);
        if(rest){
            jsonObject.put("res","修改成功");
        }else{
            jsonObject.put("res","修改失败");
        }
        return jsonObject.toJSONString();
    }
}
