package com.course.service.impl;

import com.course.mapper.StudentCourseMapper;
import com.course.mapper.StudentCourseMapperCustom;
import com.course.pojo.StudentCourse;
import com.course.pojo.StudentCourse1;
import com.course.service.IStudentCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService implements IStudentCoursService {

    @Autowired
    private StudentCourseMapperCustom studentCourseMapperCustom;

    @Override
    public List<StudentCourse1> getAllScore(Integer tid) {
        List<StudentCourse1> studentCourse = studentCourseMapperCustom.findAllScoreByTeacher(tid);
        return studentCourse;
    }

    @Override
    public boolean updateScore(StudentCourse studentCourse) {
        int res = studentCourseMapperCustom.updateScore(studentCourse);
        return res>0;
    }
}
