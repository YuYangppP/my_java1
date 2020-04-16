package com.itcast.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.IOrderDao;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 16:04
 **/
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    //分页查询订单
    @Override
    public List<Orders> findAll(Integer page, Integer size)throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    //订单详情
    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }
}
