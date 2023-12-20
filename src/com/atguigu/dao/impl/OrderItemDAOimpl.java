package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.pojo.OrderItem;

public class OrderItemDAOimpl extends BasicDao implements OrderItemDAO {

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item values(?,?,?,?,?,?);";
        update(sql,null,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrder_id());
    }
}
