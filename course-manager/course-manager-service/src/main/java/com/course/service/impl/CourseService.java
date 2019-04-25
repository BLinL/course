package com.course.service.impl;

import com.course.mapper.CourseMapper;
import com.course.pojo.Course;
import com.course.pojo.CourseExample;
import com.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        List<Course> course = courseMapper.selectByExample(courseExample);
        return course;
    }
}
