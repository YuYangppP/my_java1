package com.yu.erp.sys.service.impl;

import com.yu.erp.sys.domain.Role;
import com.yu.erp.sys.mapper.RoleMapper;
import com.yu.erp.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-03-26
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public boolean removeById(Serializable id) {
        //根据角色ID删除sys_role_permission里面的数据
        this.getBaseMapper().deleteRolePermissionByRid(id);
        //根据角色ID删除sys_role_user里面的数据
        this.getBaseMapper().deleteRoleUserByRid(id);
        return super.removeById(id);
    }

    /**
     *         //根据角色ID查询当前角色拥有的权限和菜单
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> queryRolePermissionIdsByRid(Integer roleId) {
       return this.getBaseMapper().queryRolePermissionIdsByRid(roleId);
    }

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param ids
     */
    @Override
    public void saveRolePermission(Integer rid, Integer[] ids) {

        RoleMapper roleMapper = this.getBaseMapper();
        roleMapper.deleteRolePermissionByRid(rid);
        if (ids!=null&&ids.length>0){
            for (Integer pid : ids) {
                roleMapper.saveRolePermission(rid,pid);

            }
        }

    }

    @Override
    public List<Integer> queryUserRoleIdsByUid(Integer id) {

        return this.getBaseMapper().queryUserRoleIdsByUid(id);
    }
}
