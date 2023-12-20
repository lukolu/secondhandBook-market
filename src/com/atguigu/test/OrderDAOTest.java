package com.atguigu.test;

import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.impl.OrderDAOimpl;
import com.atguigu.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    private OrderDAO orderDAO=new OrderDAOimpl();

    @Test
    void createOrder() {
        orderDAO.createOrder(new Order("123456",new Date(),new BigDecimal(100),0, 1));
    }
}