package com.course.service;

import com.course.pojo.Userlogin;

public interface ILoginService {
     Userlogin findByName(String username);

}
