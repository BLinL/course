package com.course.mapper;

import com.course.pojo.StudentCourse;
import com.course.pojo.StudentCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    long countByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int deleteByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int insert(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int insertSelective(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    List<StudentCourse> selectByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_course
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);
}