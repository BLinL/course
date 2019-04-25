package com.course.service;

import com.course.pojo.Privilege;

import java.util.Set;

public interface IPrivilegeService {
    public Set<Privilege> getByID(Integer id);
}
