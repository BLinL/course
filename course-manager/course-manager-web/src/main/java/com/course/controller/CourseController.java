package com.course.controller;

import com.course.pojo.Course;
import com.course.pojo.Student;
import com.course.service.ICourseService;
import com.course.service.IStudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentService studentService;


    @RequestMapping(value = "getdata",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getData(){
        ObjectMapper objectMapper = new ObjectMapper();
        //Jackson 默认是转成timestamps形式的,需要自己格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
        List<Course> course = courseService.getCourse();
        String courseJson = "";
        try {
            courseJson = objectMapper.writeValueAsString(course);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(courseJson);

        return courseJson;
    }

    @RequestMapping(value = "getSelectedCourse" ,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getSelectedCourse() {
        ObjectMapper objectMapper = new ObjectMapper();
        //Jackson 默认是转成timestamps形式的,需要自己格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
        String selCourseJson = "";
        Subject subject = SecurityUtils.getSubject();

        Session session = subject.getSession(false);
        if(session!=null){
            String username = (String)session.getAttribute("username");
            //
            System.out.println("--------------------courseController"+username);
            if(username!=null){
                Student stu = studentService.findByUsername(username);
                Integer sid = stu.getSid();

                //获取已选课程
                List<Course> selCourse = courseService.getSelectedCourse(sid);
                try {
                    selCourseJson = objectMapper.writeValueAsString(selCourse);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println(selCourseJson);
        return selCourseJson;
    }
}
