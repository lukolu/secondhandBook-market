package com.atguigu.filter;

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user==null)
        {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
        } else
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
