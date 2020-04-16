package com.yu.erp.sys.service.impl;

import com.yu.erp.sys.domain.Permission;
import com.yu.erp.sys.mapper.PermissionMapper;
import com.yu.erp.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老雷
 * @since 2020-03-21
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public boolean removeById(Serializable id) {

        //根据

        PermissionMapper permissionMapper = this.baseMapper;
        permissionMapper.deleteRolePermissionById(id);

        //删除权限表的数据
        return super.removeById(id);
    }
}
