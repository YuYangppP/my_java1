package com.yu.erp.sys.mapper;

import com.yu.erp.sys.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 老雷
 * @since 2020-03-21
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     *
     * @param id
     */
    void deleteRolePermissionById(@Param("id") Serializable id);
}
