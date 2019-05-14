package com.course.service.impl;

import com.course.mapper.StudentCourseMapper;
import com.course.mapper.StudentMapper;
import com.course.mapper.UserloginMapper;
import com.course.pojo.*;
import com.course.service.IStudentService;
import com.course.utils.PasswordUtil;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserloginMapper userloginMapper;

    @Autowired
    private StudentCourseMapper studentCourseMapper;


    /**
     * 注册
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        /**
         * student 和userLogin 表都要插入输入据
         */

        Userlogin userlogin = new Userlogin(student.getUsername(),student.getPassword());

        //设置学生权限
        userlogin.setRole(1);
        userlogin.setUserid(student.getSid());
        PasswordUtil passwordUtil = new PasswordUtil();
        //密码MD5加密
        passwordUtil.encryptPassword(userlogin);
        int res = userloginMapper.insert(userlogin);
        int res1 = studentMapper.insert(student);
        return res>0 && res1>0;
    }

    /**
     * 更新信息
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {

        return studentMapper.updateByPrimaryKey(student)>0;
    }

    //根据学号和用户名查找用户
    @Override
    public boolean findBySidAndUserName(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUsernameLike(student.getUsername());
        criteria.andSidEqualTo(student.getSid());
        List<Student> stu = studentMapper.selectByExample(studentExample);
        if(stu!=null && stu.size()!=0){
            if (stu.get(0)!=null){
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findByUsername(String username) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUsernameLike(username);
        List<Student> student = studentMapper.selectByExample(studentExample);
        return student == null?null:student.get(0);
    }

    @Override
    public boolean addCourse(StudentCourse studentCourse) {
        int res = studentCourseMapper.insert(studentCourse);
        return res > 0;
    }

    @Override
    public boolean deleteCourse(StudentCourse studentCourse) {
        StudentCourseExample studentCourseExample = new StudentCourseExample();
        StudentCourseExample.Criteria critera = studentCourseExample.createCriteria();
        critera.andStudentidEqualTo(studentCourse.getStudentid());
        critera.andCourseidEqualTo(studentCourse.getCourseid());
        int res = studentCourseMapper.deleteByExample(studentCourseExample);
        return res > 0;
    }
}

