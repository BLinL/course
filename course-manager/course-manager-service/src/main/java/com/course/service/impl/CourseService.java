package com.course.service.impl;

import com.course.mapper.CourseMapper;
import com.course.mapper.StudentCourseMapper;
import com.course.pojo.*;
import com.course.service.ICourseService;
import com.course.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentCourseMapper studentCourseMapper;
    /**
     * 所有课程
     * @return
     */
    @Override
    public List<Course> getCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        List<Course> course = courseMapper.selectByExample(courseExample);
        return course;
    }

    /**
     * 查询已选课程
     * @return
     */
    @Override
    public List<Course> getSelectedCourse(Integer sid) {
        List<Course> selCourse = new ArrayList<>();
        StudentCourseExample studentCourseExample = new StudentCourseExample();
        StudentCourseExample.Criteria criteria = studentCourseExample.createCriteria();
        criteria.andStudentidEqualTo(sid);
        List<StudentCourse> studentCourse = studentCourseMapper.selectByExample(studentCourseExample);

        //所选课程id
        List<Integer> cid = new ArrayList<>();
        for(StudentCourse sc : studentCourse){
            cid.add(sc.getCourseid());
        }

        if(cid.size()>0){

            for(Integer id:cid){
                CourseExample courseExample = new CourseExample();
                CourseExample.Criteria criteria1 = courseExample.createCriteria();

                criteria1.andCidEqualTo(id);
                List<Course> course = courseMapper.selectByExample(courseExample);
                if(course!=null && course.size()!=0){
                    Course coursedd = course.get(0);
                    selCourse.add(coursedd);
                }
            }

        }

        return selCourse;
    }


    public List<Course> getNotSelectedCourse(Integer sid){
        List<Course> notSelCourse = new ArrayList<>();
        StudentCourseExample studentCourseExample = new StudentCourseExample();
        StudentCourseExample.Criteria criteria = studentCourseExample.createCriteria();
        criteria.andStudentidEqualTo(sid);
        List<StudentCourse> studentCourse = studentCourseMapper.selectByExample(studentCourseExample);

        //所选课程id
        List<Integer> cid = new ArrayList<>();
        for(StudentCourse sc : studentCourse){
            cid.add(sc.getCourseid());
        }

        if(cid.size()>0){
            CourseExample courseExample = new CourseExample();
            CourseExample.Criteria criteria1 = courseExample.createCriteria();
            criteria1.andCidNotIn(cid);
            notSelCourse = courseMapper.selectByExample(courseExample);
        }

        return notSelCourse;

    }

//    public static void main(String[] args) {
//        PasswordUtil passwordUtil = new PasswordUtil();
//        passwordUtil.encryptPassword(new Userlogin("罗宾","123"));
//    }
}
