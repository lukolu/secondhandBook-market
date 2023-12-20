package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDAO;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;

public class OrderDAOimpl extends BasicDao implements OrderDAO {

    @Override
    public void createOrder(Order order) {
        String sql="insert into t_order value(?,?,?,?,?)";
        update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUserid());
    }
}
