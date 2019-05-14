package com.course.service;

import com.course.pojo.Notice;

import java.util.List;

public interface INoticeServie {
    public boolean publish(Notice notice);

    public Notice getNotice();

    public List<Notice> getAllNotice();
}
