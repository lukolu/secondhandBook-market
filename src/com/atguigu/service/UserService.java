package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    public void register(User user);
    public User login(User user);
    public boolean UsernameIsExist(String name);
}
