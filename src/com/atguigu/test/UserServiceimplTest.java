package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import org.junit.jupiter.api.Test;

class UserServiceimplTest {

    @Test
    void register() {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        if (userServiceimpl.UsernameIsExist("李四")) {
            System.out.println("该用户已存在！");
            return;
        }
        userServiceimpl.register(new User(null, "李四", "123", "456@qq.com"));
         System.out.println("注册成功");
    }

    @Test
    void login() {
    }

    @Test
    void usernameIsExist() {
    }
}