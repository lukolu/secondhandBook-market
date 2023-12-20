package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class UserServlet extends BaseServlet {

    private UserServiceimpl userServiceimpl =new UserServiceimpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userServiceimpl.login(new User(null,username,password,null));
        if (user!=null)
        {
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
        else
        {
            req.setAttribute("msg","登录信息有误!");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code=(String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        User user= WebUtils.copyParameterToBean(new User(),req.getParameterMap());

        if (code!=null && code.equalsIgnoreCase(req.getParameter("code")))
        {
            if (userServiceimpl.UsernameIsExist(user.getUsername()))
            {
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
            else
            {
                System.out.println("注册成功");
                userServiceimpl.register(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }
        else
        {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
        System.out.println(req.getContextPath());
    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        boolean b = userServiceimpl.UsernameIsExist(username);


        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("ExistUsername",b);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);
    }
}
