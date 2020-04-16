package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-18 10:33
 **/
public interface ISysLogService {
    //保存日志信息
    void save(SysLog sysLog);

    //查询所有日志
    List<SysLog> findAll();
}
