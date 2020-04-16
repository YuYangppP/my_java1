package com.yu.mapper;

import com.yu.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户id查询用户拥有的角色
     * @param userid
     * @return
     */
    List<Role> queryRolesByUserId(@Param("userid") Integer userid);
}