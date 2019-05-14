package com.course.service.impl;

import com.common.pojo.EasyUIPagination;
import com.course.mapper.CourseMapper;
import com.course.mapper.CourseMapperCustom;
import com.course.mapper.StudentCourseMapper;
import com.course.mapper.UserloginMapper;
import com.course.pojo.*;
import com.course.service.ICourseService;
import com.course.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    public CourseMapperCustom courseMapperCustom;

    @Autowired
    private StudentCourseMapper studentCourseMapper;
    /**
     * 所有课程
     * @return
     */
    @Override
    public PagingVo getCourse(EasyUIPagination easyUIPagination) {
//        CourseExample courseExample = new CourseExample();
//        CourseExample.Criteria criteria = courseExample.createCriteria();
//        List<Course> course = courseMapper.selectByExample(courseExample);
        List<Course> course = courseMapperCustom.findAllByPaging(easyUIPagination);
        PagingVo pagingVo = new PagingVo();
        int rows = courseMapperCustom.findAllRows();
        pagingVo.setTotal(rows);
        pagingVo.setRows(course);
        return pagingVo;
    }

    @Override
    public int findRows() {
        return courseMapperCustom.findAllRows();
    }

    /***
     * 分页查询某个老师所开设的课程
     */
    @Override
    public List<Course> getByTid(Integer tid) {
        Map map = new HashMap<>();
        map.put("tid",tid);

        courseMapperCustom.findByPaging(map);
        return null;
    }

    /**
     * 改变课程为 已审核
     * @param
     * @return
     */
    @Override
    public boolean agreeCourse(Integer courseId) {
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStatus(0);
        int res = courseMapper.updateByPrimaryKey(course);
        return res>0;
    }

    @Override
    public boolean disagreeCourse(Integer courseId) {
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStatus(1);
        int res = courseMapper.updateByPrimaryKey(course);
        return res>0;
    }
    /**
     * 获取未审核课程
     * @param easyUIPagination
     * @return
     */
    @Override
    public PagingVo getCourseUnChecked(EasyUIPagination easyUIPagination) {
        List<Course> course = courseMapperCustom.findUncheckCourse(easyUIPagination);
        PagingVo pagingVo = new PagingVo();
        int rows = courseMapperCustom.findUncheckCourseRows();
        pagingVo.setTotal(rows);
        pagingVo.setRows(course);
        return pagingVo;
    }

    /**
     * 查询已选课程
     * @return
     */
    @Override
    public List<Course> getSelectedCourse(Integer sid) {
        List<Course> selCourse = new ArrayList<>();
        StudentCourseExample studentCourseExample = new StudentCourseExample();
        StudentCourseExample.Criteria criteria = studentCourseExample.createCriteria();
        criteria.andStudentidEqualTo(sid);
        List<StudentCourse> studentCourse = studentCourseMapper.selectByExample(studentCourseExample);

        //所选课程id
        List<Integer> cid = new ArrayList<>();
        for(StudentCourse sc : studentCourse){
            cid.add(sc.getCourseid());
        }

        if(cid.size()>0){

            for(Integer id:cid){
                CourseExample courseExample = new CourseExample();
                CourseExample.Criteria criteria1 = courseExample.createCriteria();

                criteria1.andCidEqualTo(id);
                List<Course> course = courseMapper.selectByExample(courseExample);
                if(course!=null && course.size()!=0){
                    Course coursedd = course.get(0);
                    selCourse.add(coursedd);
                }
            }

        }

        return selCourse;
    }


    public List<Course> getNotSelectedCourse(Integer sid){
        List<Course> notSelCourse = new ArrayList<>();
        StudentCourseExample studentCourseExample = new StudentCourseExample();
        StudentCourseExample.Criteria criteria = studentCourseExample.createCriteria();
        criteria.andStudentidEqualTo(sid);
        List<StudentCourse> studentCourse = studentCourseMapper.selectByExample(studentCourseExample);

        //所选课程id
        List<Integer> cid = new ArrayList<>();
        for(StudentCourse sc : studentCourse){
            cid.add(sc.getCourseid());
        }

        if(cid.size()>0){
            CourseExample courseExample = new CourseExample();
            CourseExample.Criteria criteria1 = courseExample.createCriteria();
            criteria1.andCidNotIn(cid);
            notSelCourse = courseMapper.selectByExample(courseExample);
        }

        return notSelCourse;

    }



    @Override
    public boolean addCourse(Course course) {
        int re = courseMapper.insert(course);
        return re > 0;
    }

    @Override
    public boolean updateCourse(Course course) {
        int re = courseMapper.updateByPrimaryKey(course);
        return re > 0;
    }

    @Override
    public boolean deleteCourse(Integer cid) {
        int re = courseMapper.deleteByPrimaryKey(cid);
        return re > 0;
    }

    public static void main(String[] args) {
        PasswordUtil passwordUtil = new PasswordUtil();
        passwordUtil.encryptPassword(new Userlogin("admin","123"));
    }
}
