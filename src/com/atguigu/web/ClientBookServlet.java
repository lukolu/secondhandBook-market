package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class ClientBookServlet extends BaseServlet{
    private BookServiceimpl bookServiceimpl=new BookServiceimpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，当前页数默认为1,每页记录数为PAGE_SIZE=4
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //获取Page对象
        Page<Book> page = bookServiceimpl.getPage(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //把page对象保存在request的域数据中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        //获取Page对象
        Page<Book> page = bookServiceimpl.getPageByPrice(pageNo, pageSize,max,min);

        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");

        if (req.getParameter("min")!=null)
        {
            stringBuilder.append("&min="+req.getParameter("min"));
        }
        if (req.getParameter("max")!=null)
        {
            stringBuilder.append("&max="+req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        //把page对象保存在request的域数据中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
