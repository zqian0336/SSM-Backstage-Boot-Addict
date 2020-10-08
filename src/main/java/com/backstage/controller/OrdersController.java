package com.backstage.controller;

import com.backstage.pojo.Orders;
import com.backstage.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    protected OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping("findAllOrders")
    public ModelAndView findAllOrders(int page, int pageSize){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAllOrders(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;

    }

    @GetMapping("findOrdersById")
    public ModelAndView findOrdersById(String ordersId){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findOrdersById(ordersId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
