package com.course.pojo;


import java.util.List;

public class PagingVo{

    private int total;
    private List<Course> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<Course> getRows() {
        return rows;
    }

    public void setRows(List<Course> rows) {
        this.rows = rows;
    }
}
