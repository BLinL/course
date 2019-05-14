package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.mapper.CourseMapper;
import com.course.pojo.*;
import com.course.service.ICourseService;
import com.course.service.IStudentService;
import com.course.service.impl.CourseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;
    /**
     * 注册 首先判断是否已存在该用户
     * @param student
     * @return
     */
    @RequestMapping(value = "/addStudent" )
    @ResponseBody
    public ReturnMessage add(Student student){
        System.out.println(student.toString());
        //判断用户是否存在
        if(! studentService.findBySidAndUserName(student)){
            if(studentService.addStudent(student))
                return new ReturnMessage("true","注册成功");
        }
        return new ReturnMessage("false","注册失败，用户已存在");
    }

    @RequestMapping(value = "/showCourse")
    public void showCourse()
    {

        System.out.println("showCourse");
    }

    @RequestMapping(value="/selCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectCourse(String cid){
        JSONObject jsonObject = new JSONObject();
        System.out.println(cid);
        if(cid == null){
            jsonObject.put("res","请选择课程");
            return jsonObject.toJSONString();
        }


        //获取当前登录学生用户
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        Userlogin currUser = (Userlogin) session.getAttribute("currUser");

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseid(Integer.parseInt(cid));
        studentCourse.setStudentid(currUser.getUserid());


        List<Course> courseList = courseService.getSelectedCourse(currUser.getUserid());
        for (Course course : courseList){
            if(course.getCid() == Integer.parseInt(cid)){
                //已选该课程，不应该再插入
                jsonObject.put("res","您已选过该课程！");
                return jsonObject.toJSONString();
            }
        }

        boolean result = false;
        result = studentService.addCourse(studentCourse);
        if(result){
            jsonObject.put("res","ok");
        }else{
            jsonObject.put("res","您已选过该课程！");
        }

        System.out.println(jsonObject.toJSONString());
        return jsonObject.toJSONString();


    }

    @RequestMapping(value="/removeCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String removeCourse(String cid){

        System.out.println(cid);
        JSONObject jsonObject = new JSONObject();
        if(cid == null){
            jsonObject.put("res","请选择课程");
            return jsonObject.toJSONString();
        }


        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        Userlogin currUser = (Userlogin) session.getAttribute("currUser");
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseid(Integer.parseInt(cid));
        studentCourse.setStudentid(currUser.getUserid());


        boolean result = false;

        result = studentService.deleteCourse(studentCourse);
        if(result){
            jsonObject.put("res","ok");
        }
        System.out.println(jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }

}
