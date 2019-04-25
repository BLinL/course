package com.course.service.impl;

import com.course.mapper.UserloginMapper;
import com.course.pojo.Userlogin;
import com.course.pojo.UserloginExample;
import com.course.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserloginMapper userloginMapper;


    @Override
    public Userlogin findByName(String username) {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<Userlogin> user = userloginMapper.selectByExample(userloginExample);
        if(user == null || user.size() == 0){
            return null;
        }
        return user.get(0);
    }
}
