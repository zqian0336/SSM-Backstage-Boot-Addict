package com.backstage.service;

import com.backstage.pojo.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAllOrders(int page, int pageSize);

    Orders findOrdersById(String ordersId);
}
