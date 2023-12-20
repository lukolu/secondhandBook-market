package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceimpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService=new OrderServiceimpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        User user = (User) req.getSession().getAttribute("user");



        String   order_id = orderService.createOrder(cart, user.getId());

        req.setAttribute("order_id",order_id);

        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
    }
}
