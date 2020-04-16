package com.yu.mapper;

import com.yu.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer perid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据用户id查询用户权限
     * @param userid
     * @return
     */
    List<Permission> queryPermissionsByUserId(@Param("userid") Integer userid);
}