package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author:yuyang
 * @data:2019-05-20 17:54
 **/
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id)throws Exception;
}
