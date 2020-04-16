package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IPermissionDao;
import com.itcast.ssm.dao.IRoleDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:07
 **/
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private IPermissionDao permissionDao;


    //查询所有角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    //添加角色
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRoles(String userId) {
        return roleDao.findOtherRoles(userId);
    }


    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }


    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
