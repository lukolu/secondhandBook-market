package com.atguigu.service.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.BookDAOimpl;
import com.atguigu.dao.impl.OrderDAOimpl;
import com.atguigu.dao.impl.OrderItemDAOimpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceimpl implements OrderService {
    private OrderDAO orderDAO=new OrderDAOimpl();
    private OrderItemDAO orderItemDAO=new OrderItemDAOimpl();
    private BookDAO bookDAO=new BookDAOimpl();
    @Override
    public String createOrder(Cart cart, int userid) {
        String order_id=System.currentTimeMillis()+""+userid;
        Order order = new Order(order_id, new Date(), cart.getTotalPrice(), 0, userid);
        orderDAO.createOrder(order);


        for (Map.Entry<Integer,CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),order_id);
            orderItemDAO.saveOrderItem(orderItem);
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDAO.updateBook(book);

        }

        cart.clearItem();

        return order.getOrder_id();
    }
}
