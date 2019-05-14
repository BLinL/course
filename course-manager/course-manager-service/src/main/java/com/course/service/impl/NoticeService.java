package com.course.service.impl;

import com.course.mapper.NoticeMapper;
import com.course.mapper.NoticeMapperCustom;
import com.course.pojo.Notice;
import com.course.pojo.NoticeExample;
import com.course.service.INoticeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService implements INoticeServie {
    @Autowired
    private NoticeMapperCustom noticeMapperCustom;
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public boolean publish(Notice notice) {
        int res = noticeMapper.insert(notice);
        return res>0;
    }

    @Override
    public Notice getNotice() {
        Notice notice1 = noticeMapperCustom.getOne();
        return notice1;
    }

    @Override
    public List<Notice> getAllNotice() {
        NoticeExample noticeExample = new NoticeExample();
        List<Notice> list = noticeMapper.selectByExample(noticeExample);
        return list;
    }
}
