package com.atguigu.filter;

import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
