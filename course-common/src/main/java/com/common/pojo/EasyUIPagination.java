package com.common.pojo;

public class EasyUIPagination {
    private int page;
    private int rows;
    private int begin;

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
