package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDAO {
    public User queryUsername(String username);
    public User queryUsernameAndPassword(String username,String password);

    public int saveUser(User user);
}
