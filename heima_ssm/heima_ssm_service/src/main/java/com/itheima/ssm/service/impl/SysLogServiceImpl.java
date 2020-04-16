package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-18 10:34
 **/
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;

    //保存日志信息
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    //查询所有日志
    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
