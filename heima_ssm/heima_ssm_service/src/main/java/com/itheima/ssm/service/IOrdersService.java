package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-14 15:29
 **/
public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
