package com.itcast.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 15:58
 **/
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //查询所有订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = orderService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
