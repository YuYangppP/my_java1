package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 17:53
 **/
public interface ITravellersDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
