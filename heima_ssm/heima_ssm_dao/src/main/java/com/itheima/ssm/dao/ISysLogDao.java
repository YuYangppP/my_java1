package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-18 10:36
 **/
public interface ISysLogDao {
    //保存日志
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    //查询所有日志
    @Select("select * from syslog")
    List<SysLog> findAll();
}
