package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookServiceimpl bookServiceimpl=new BookServiceimpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookServiceimpl.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book= WebUtils.copyParameterToBean(new Book(),req.getParameterMap());
        bookServiceimpl.addBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookServiceimpl.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookServiceimpl.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?action=update").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book= WebUtils.copyParameterToBean(new Book(),req.getParameterMap());

        bookServiceimpl.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，当前页数默认为1,每页记录数为PAGE_SIZE=4
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //获取Page对象
        Page<Book> page = bookServiceimpl.getPage(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //把page对象保存在request的域数据中
        req.setAttribute("page",page);
        //请求转发到图书管理页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
