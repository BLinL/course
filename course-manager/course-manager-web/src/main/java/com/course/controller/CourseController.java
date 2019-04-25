package com.course.controller;

import com.course.pojo.Course;
import com.course.service.ICourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CourseController {


    @Autowired
    private ICourseService courseService;



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

}
