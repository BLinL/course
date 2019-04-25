package com.course.service.impl;

import com.course.mapper.RoleMapper;
import com.course.pojo.Role;
import com.course.pojo.RoleExample;
import com.course.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByID(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }
}
