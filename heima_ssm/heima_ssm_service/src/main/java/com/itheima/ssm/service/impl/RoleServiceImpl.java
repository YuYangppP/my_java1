package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
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
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId );
        }
    }
}
