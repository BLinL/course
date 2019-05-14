import com.common.pojo.EasyUIPagination;
import com.course.mapper.CourseMapperCustom;
import com.course.mapper.StudentCourseMapper;
import com.course.mapper.StudentCourseMapperCustom;
import com.course.pojo.Course;
import com.course.pojo.StudentCourse1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class CourseCustomTest {

    @Autowired
    CourseMapperCustom courseMapperCustom;

    @Autowired
    StudentCourseMapperCustom studentCourseMapperCustom;
    @Test
    public void test(){
        EasyUIPagination easyUIPagination = new EasyUIPagination();
        easyUIPagination.setBegin(0);
        easyUIPagination.setRows(10);
        List<Course> list = courseMapperCustom.findUncheckCourse(easyUIPagination);
        System.out.println(list.size());

//        StudentCourse1 studentcourse = studentCourseMapperCustom.findAllScore();
//        System.out.println(studentcourse);
    }
}
