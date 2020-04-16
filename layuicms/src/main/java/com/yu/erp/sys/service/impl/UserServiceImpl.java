package com.yu.erp.sys.service.impl;

import com.yu.erp.sys.domain.User;
import com.yu.erp.sys.mapper.RoleMapper;
import com.yu.erp.sys.mapper.UserMapper;
import com.yu.erp.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity);
    }

    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean removeById(Serializable id) {
        //根据用户Id删除用户角色中间表数据
        roleMapper.deleteRoleUserByUid(id);
        //删除用户头像，如果头像是默认的，不删除
        return super.removeById(id);
    }

    /**
     * 保存用户和角色之间的关系
     * @param uid
     * @param ids
     */
    @Override
    public void saveUserRole(Integer uid, Integer[] ids) {
        //根据用户Id删除sys_user_role里面的数据
        this.roleMapper.deleteRoleUserByUid(uid);
        if (null!=ids&&ids.length>0){
            for (Integer rid : ids) {
                this.roleMapper.insertUserRole(uid,rid);
            }
        }
    }
}
