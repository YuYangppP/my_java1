package com.itcast.ssm.dao;

import com.itcast.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-21 21:08
 **/
public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    //查询所有日志
    @Select("select * from syslog")
    List<SysLog> findAll();
}
