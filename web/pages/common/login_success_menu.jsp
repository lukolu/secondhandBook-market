<%@ page import="com.atguigu.utils.CookieUtils" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/9/25
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>
    <a href="index.jsp">返回</a>
</div>
