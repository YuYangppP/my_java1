package com.itcast.ssm.service;

import com.itcast.ssm.domain.SysLog;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-21 21:06
 **/
public interface ISysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
