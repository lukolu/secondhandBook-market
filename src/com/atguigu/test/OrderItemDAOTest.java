package com.atguigu.test;

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemDAOimpl;
import com.atguigu.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDAOTest {
    private OrderItemDAO orderItemDAO=new OrderItemDAOimpl();

    @Test
    void saveOrderItem() {
        orderItemDAO.saveOrderItem(new OrderItem(null,"java 从入门到精通", 1,new BigDecimal(100),new
                BigDecimal(100),"123456"));
    }
}