package com.course;

import com.course.pojo.Student;
import com.course.service.impl.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-service.xml",
        "classpath:/spring/applicationContext-dao.xml","classpath:/spring/applicationContext-shrio.xml",
        "classpath:/spring/applicationContext-trans.xml"

})
public class test {

    @Autowired
    StudentService studentService;


    @Test
    public void test(){

        Student student = studentService.findByUsername("张三");
        System.out.println(student);
    }
}
