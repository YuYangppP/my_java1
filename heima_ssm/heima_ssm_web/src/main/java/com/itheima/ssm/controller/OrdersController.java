package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-14 15:29
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true) String ordersId)throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page" ,required = true,defaultValue = "1") Integer page,@RequestParam(name="size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Orders> ordersList = ordersService.findAll(page,size);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
}
