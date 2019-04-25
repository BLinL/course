package com.course.pojo;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public class PagingVo {

    private int currPage;//当前页

    private int totalCount;//总页数

    private int pageSize;//每页的条数

    private int rows;//数据总条数

    private List<Course> coourseList;

    public PagingVo(int currPage, int totalCount) {
        this.currPage = currPage;
        this.totalCount = totalCount;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<Course> getCoourseList() {
        return coourseList;
    }

    public void setCoourseList(List<Course> coourseList) {
        this.coourseList = coourseList;
    }
}
