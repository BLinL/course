package com.course.pojo;

public class StudentPrivilege extends Student {
    private Integer id;
    private String privilegename;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename;
    }
}
