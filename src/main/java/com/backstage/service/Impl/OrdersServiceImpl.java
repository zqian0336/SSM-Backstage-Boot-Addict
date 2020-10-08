package com.backstage.service.Impl;

import com.backstage.dao.OrdersDao;
import com.backstage.pojo.Orders;
import com.backstage.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersDao ordersDao;

    @Autowired
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public List<Orders> findAllOrders(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAllOrders();
    }

    @Override
    public Orders findOrdersById(String ordersId) {
        return ordersDao.findOrdersById(ordersId);
    }

}
