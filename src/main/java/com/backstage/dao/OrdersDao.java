package com.backstage.dao;

import com.backstage.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface OrdersDao {

    List<Orders> findAllOrders();

    Orders findOrdersById(String ordersId);
}
