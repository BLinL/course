package com.course.service;

import com.course.pojo.Course;

import java.util.List;

public interface ICourseService {
    //获取所有课程
    public List<Course> getCourse();

    //获取已选课程
    public List<Course> getSelectedCourse(Integer sid);

    //获取未选课程
    public List<Course> getNotSelectedCourse(Integer sid);
}
