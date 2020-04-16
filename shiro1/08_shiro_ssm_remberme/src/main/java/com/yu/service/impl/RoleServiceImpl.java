package com.yu.service.impl;

import com.yu.domain.Role;
import com.yu.service.RoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yu.mapper.RoleMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    public List<String> queryRolesByUserId(Integer userid) {
        List<Role> roleList = roleMapper.queryRolesByUserId(userid);
        List<String> roles = new ArrayList<String>();
        for (Role role : roleList) {
            roles.add(role.getRolename());
        }
        return roles;
    }
}
