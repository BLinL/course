package com.course.service;

import com.course.pojo.StudentCourse;
import com.course.pojo.StudentCourse1;

import java.util.List;

public interface IStudentCoursService {
    public List<StudentCourse1> getAllScore(Integer tid);

    public boolean updateScore(StudentCourse studentCourse);
}
