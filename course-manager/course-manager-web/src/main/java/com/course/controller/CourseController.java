package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.pojo.Course;
import com.course.pojo.PagingVo;
import com.course.pojo.Student;
import com.course.pojo.Userlogin;
import com.course.service.ICourseService;
import com.course.service.IStudentService;
import com.course.service.impl.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.common.pojo.EasyUIPagination;


import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "getdata",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getData(EasyUIPagination easyUIPagination){
        int rows = easyUIPagination.getRows();
        int page = easyUIPagination.getPage();

        int begin = (page-1) * rows;
        easyUIPagination.setBegin(begin);
        ObjectMapper objectMapper = new ObjectMapper();
        //Jackson 默认是转成timestamps形式的,需要自己格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
//        List<Course> course = courseService.getCourse();
        PagingVo course = courseService.getCourse(easyUIPagination);
        System.out.println("course"+course);
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


    @RequestMapping(value = "addCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addCourse(Course course){
        System.out.println("添加课程："+course);
//        Subject subject = SecurityUtils.getSubject();
//        Object principle = subject.getPrincipal();
//        Userlogin curUser = loginService.findByName((String) principle);
//        course.setCid(curUser.getUserid());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        Userlogin curUser = null;
        if(session!=null){
            curUser = (Userlogin)session.getAttribute("currUser");
        }
        if(curUser!=null){
            course.setTid(curUser.getUserid());
        }
        System.out.println(course);
        JSONObject jsonObject = new JSONObject();
        boolean result = courseService.addCourse(course);

        if(result){
            jsonObject.put("res","ok");
        }else{
            jsonObject.put("res","false");
        }

        return jsonObject.toJSONString();

    }

    @RequestMapping(value = "delCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delCourse(Integer cid){
        JSONObject jsonObject = new JSONObject();
        boolean result = courseService.deleteCourse(cid);

        if(result){
            jsonObject.put("res","ok");
        }else{
            jsonObject.put("res","删除失败");
        }

        return jsonObject.toJSONString();

    }


    @RequestMapping(value = "updateCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateCourse(Course course){
        JSONObject jsonObject = new JSONObject();
        boolean result = courseService.updateCourse(course);

        if(result){
            jsonObject.put("res","ok");
        }else{
            jsonObject.put("res","修改失败");
        }

        return jsonObject.toJSONString();

    }


    @RequestMapping(value = "updateCourseStatus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String setPassCourse(Integer cid){
        System.out.println("更改课程："+cid);
        JSONObject jsonObject = new JSONObject();
        boolean result = courseService.agreeCourse(cid);
        if(result){
            jsonObject.put("res","修改成功");
        }else{
            jsonObject.put("res","修改失败");
        }

        return jsonObject.toJSONString();

    }


    /**
     * 获取未审核课程 status = 0
     * @param easyUIPagination
     * @return
     */
    @RequestMapping(value = "getUnPassedCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getUnPassedCourse(EasyUIPagination easyUIPagination){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
        String selCourseJson = "";
        int rows = easyUIPagination.getRows();
        int page = easyUIPagination.getPage();
        int begin = (page-1) * rows;
        easyUIPagination.setBegin(begin);
        PagingVo pagingVo = courseService.getCourseUnChecked(easyUIPagination);

        try {
            selCourseJson = objectMapper.writeValueAsString(pagingVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return selCourseJson;

    }
}
