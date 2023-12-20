package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends BaseServlet{
    private BookServiceimpl bookServiceimpl=new BookServiceimpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookServiceimpl.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null)
        {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastAddItemName",cartItem.getName());

        System.out.println("id为"+id+"成功加入到购物车");

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null)
        {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if (cart!=null)
        {
            cart.clearItem();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if (cart!=null) {
            cart.changeItem(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookServiceimpl.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null)
        {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastAddItemName",cartItem.getName());

        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("lastAddItemName",cartItem.getName());
        stringObjectHashMap.put("totalCount",cart.getTotalCount());

        Gson gson = new Gson();
        String s = gson.toJson(stringObjectHashMap);
        resp.getWriter().write(s);


    }
}
