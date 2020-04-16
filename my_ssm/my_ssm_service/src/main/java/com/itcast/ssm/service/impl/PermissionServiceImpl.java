package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IPermissionDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:51
 **/
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) {
        permissionDao.save(p);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return permissionDao.findOtherPermissions(roleId);
    }


}
