package com.common.pojo;

/**
 * page：页码，起始值 1。
 * rows：每页显示行。
 * @author bliu
 */
public class EasyUIPagination {
    private int page;//页码
    private int rows;//每页条目数
    private int begin;//查询起始

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "EasyUIPagination{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
