package com.yu.service.impl;

import com.yu.domain.Permission;
import com.yu.service.PermissionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.yu.mapper.PermissionMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    public List<String> queryPermissionsByUserId(Integer userid) {
        List<Permission> permissionList=permissionMapper.queryPermissionsByUserId(userid);
        List<String> permissions=new ArrayList<String>();

        for (Permission permission : permissionList) {
            permissions.add(permission.getPercode());
        }
        return permissions;
    }
}
