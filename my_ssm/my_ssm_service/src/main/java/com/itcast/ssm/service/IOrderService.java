package com.itcast.ssm.service;

import com.itcast.ssm.domain.Orders;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 16:04
 **/
public interface IOrderService {
    //分页查询订单
    List<Orders> findAll(Integer page, Integer size) throws Exception;

    //订单详情
    Orders findById(String id);
}
