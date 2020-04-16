package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author:yuyang
 * @data:2019-05-14 17:55
 **/
public interface IMemberDao {
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
