package com.course.mapper;

import com.course.pojo.StudentCourse;
import com.course.pojo.StudentCourse1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseMapperCustom {
    public List<StudentCourse1> findAllScoreByTeacher(Integer tid);

    public int updateScore(StudentCourse studentCourse);
}
