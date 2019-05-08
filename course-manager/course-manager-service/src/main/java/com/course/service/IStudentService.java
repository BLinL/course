package com.course.service;

import com.course.pojo.Student;
import com.course.pojo.StudentCourse;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;


public interface IStudentService{
    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean findBySidAndUserName(Student student);

    Student findByUsername(String username);

    boolean addCourse(StudentCourse studentCourse) throws SQLException;

    boolean deleteCourse(StudentCourse studentCourse) throws SQLException;

}
