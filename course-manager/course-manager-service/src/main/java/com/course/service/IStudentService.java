package com.course.service;

import com.course.pojo.Student;
import org.springframework.stereotype.Repository;


public interface IStudentService{
    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean findBySidAndUserName(Student student);
}
