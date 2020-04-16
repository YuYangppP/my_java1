package com.yu.erp.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yu.erp.sys.domain.Dept;
import com.yu.erp.sys.mapper.DeptMapper;
import com.yu.erp.sys.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-03-25
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Override
    public Dept getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean updateById(Dept entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean save(Dept entity) {
        return super.save(entity);
    }
}
