package com.atguigu.service.impl;

import com.atguigu.dao.impl.UserDAOimpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceimpl implements UserService {
    private UserDAOimpl userDAOimpl =new UserDAOimpl();
    @Override
    public void register(User user) {
        userDAOimpl.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAOimpl.queryUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean UsernameIsExist(String name) {
        User user = userDAOimpl.queryUsername(name);
        if (user!=null) return true;
        return false;
    }
}
