package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.domain.Product;
import com.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 16:11
 **/
public interface IOrderDao {


    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itcast.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    //订单详情
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itcast.ssm.dao.IProductDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itcast.ssm.dao.ITravellersDao.findByOrdersId")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itcast.ssm.dao.IMemberDao.findById"))

    })
    public Orders findById(String id);
}
