package com.course.service.impl;

import com.course.mapper.StudentMapper;
import com.course.mapper.UserloginMapper;
import com.course.pojo.Student;
import com.course.pojo.StudentExample;
import com.course.pojo.Userlogin;
import com.course.service.IStudentService;
import com.course.utils.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserloginMapper userloginMapper;


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

//    public static void main(String[] args) {
//        String hashAlgorithmName = "MD5";
//        String password = "123";
//        Object salt = ByteSource.Util.bytes("张三");
//        int hashIterations = 1024;
//        SimpleHash res = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
//        System.out.println(res);
//    }
}

