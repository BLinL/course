package com.course.service.impl;

import com.course.mapper.PrivilegeMapper;
import com.course.mapper.RolPrivMapper;
import com.course.pojo.Privilege;
import com.course.pojo.RolPriv;
import com.course.pojo.RolPrivExample;
import com.course.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PrivilegeService implements IPrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private RolPrivMapper rolPrivMapper;

    @Override
    public Set<Privilege> getByID(Integer id) {
        Set<Privilege> set = null;

        RolPrivExample rolPrivExample = new RolPrivExample();
        RolPrivExample.Criteria rolCriteria = rolPrivExample.createCriteria();
        rolCriteria.andRolIdEqualTo(id);
        //某个角色拥有的权限
        List<RolPriv> priv = rolPrivMapper.selectByExample(rolPrivExample);

        for (RolPriv rolPriv : priv){
            Privilege pri = privilegeMapper.selectByPrimaryKey(rolPriv.getPrivId());
            set.add(pri);
        }
       return set;
    }
}
