package com.course.mapper;

import com.common.pojo.EasyUIPagination;
import com.course.pojo.Course;
import com.course.pojo.PagingVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface CourseMapperCustom {
    /**
     * 查询某个老师的课程
     * @param
     * @return
     */
    public List<Course> findByPaging(Map map);

    /**
     * 查询所有
     * @param
     * @return
     */
    public List<Course> findAllByPaging(EasyUIPagination easyUIPagination);

    public int findAllRows();
}
