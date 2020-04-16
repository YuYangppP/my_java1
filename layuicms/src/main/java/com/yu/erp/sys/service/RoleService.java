package com.yu.erp.sys.service;

import com.yu.erp.sys.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yu
 * @since 2020-03-26
 */
public interface RoleService extends IService<Role> {
    /**
     * 根据角色ID查询当前角色拥有的权限和菜单
     * @param roleId
     * @return
     */

    List<Integer> queryRolePermissionIdsByRid(Integer roleId);

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param ids
     */
    void saveRolePermission(Integer rid, Integer[] ids);

    /**
     *         //查询当前用户拥有的角色的Id
     * @param id
     * @return
     */
    List<Integer> queryUserRoleIdsByUid(Integer id);
}
