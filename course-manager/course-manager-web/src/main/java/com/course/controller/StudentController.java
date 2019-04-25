package com.course.controller;

import com.course.pojo.ReturnMessage;
import com.course.pojo.Student;
import com.course.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private IStudentService studentService;
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
}
