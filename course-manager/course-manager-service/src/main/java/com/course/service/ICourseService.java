package com.course.service;

import com.common.pojo.EasyUIPagination;
import com.course.pojo.Course;
import com.course.pojo.PagingVo;

import java.util.List;

public interface ICourseService {
    //获取所有课程
    public PagingVo getCourse(EasyUIPagination easyUIPagination);

    //全部课程记录数
    public int findRows();

    //获取已选课程
    public List<Course> getSelectedCourse(Integer sid);

    //获取未选课程
    public List<Course> getNotSelectedCourse(Integer sid);

    //查询某个老师所开设的课程
    public List<Course> getByTid(Integer tid);

    //审核通过课程
    public boolean agreeCourse(Integer courseId);

    //撤销审核通过课程
    public boolean disagreeCourse(Integer courseId);

    //获取未审核的课程
    public PagingVo getCourseUnChecked(EasyUIPagination easyUIPagination);











    //添加课程
    public boolean addCourse(Course course);

    //修改课程
    public boolean updateCourse(Course course);

    //删除课程
    public boolean deleteCourse(Integer cid);
}
