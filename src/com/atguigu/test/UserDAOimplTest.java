package com.atguigu.test;

import com.atguigu.dao.impl.UserDAOimpl;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;

class UserDAOimplTest {
    private UserDAOimpl userDAOimpl =new UserDAOimpl();
    @Test
    void queryUsername() {
        User user = userDAOimpl.queryUsername("admin");
        if (user==null) System.out.println("该用户不存在"); else
        System.out.println("该用户存在");
    }

    @Test
    void queryUsernameAndPassword() {
        User user = userDAOimpl.queryUsernameAndPassword("admin", "admin");
        if (user==null) System.out.println("该用户不存在"); else
            System.out.println("该用户存在");
    }

    @Test
    void saveUser() {
        int affectedRow = userDAOimpl.saveUser(new User(null, "张三", "123456", "1543@qq.com"));
        if (affectedRow==-1) System.out.println("添加用户失败"); else System.out.println("添加用户成功");
    }
}