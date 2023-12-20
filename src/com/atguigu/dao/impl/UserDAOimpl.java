package com.atguigu.dao.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.pojo.User;

public class UserDAOimpl extends BasicDao<User> implements UserDAO {
    @Override
    public User queryUsername(String username) {
        User user = queryLine("select * from t_user where username=?", User.class, username);
        return user;
    }

    @Override
    public User queryUsernameAndPassword(String username,String password) {
        User user = queryLine("select * from t_user where username=? and password=md5(?)", User.class, username, password);
        return user;

    }

    @Override
    public int saveUser(User user) {
        int update = update("insert into t_user values(null,?,md5(?),?)", user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }
}
