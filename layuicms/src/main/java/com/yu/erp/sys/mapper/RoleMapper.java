package com.yu.erp.sys.mapper;

import com.yu.erp.sys.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2020-03-26
 */
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 根据角色ID删除sys_role_permission里面的数据
     * @param id
     */

    void deleteRolePermissionByRid(Serializable id);

    /**
     * 根据角色ID删除sys_role_user里面的数据
     * @param id
     */
    void deleteRoleUserByRid(Serializable id);

    /**
     * queryRolePermissionIdsByRid
     * @param roleId
     * @return
     */
    List<Integer> queryRolePermissionIdsByRid(Integer roleId);

    /**
     *
     * @param rid
     * @param pid
     */
    void saveRolePermission(@Param("rid")Integer rid, @Param("pid")Integer pid);

    /**
     * 根据用户Id删除用户角色中间表数据
     * @param id
     */
    void deleteRoleUserByUid(@Param("id") Serializable id);

    List<Integer> queryUserRoleIdsByUid(Integer id);


    /**
     * 保存用户和角色的关系
     * @param uid
     * @param rid
     */
    void insertUserRole(@Param("uid") Integer uid,@Param("rid") Integer rid);
}
