package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    User insertUser(double id, User user);
    default User insertUser(User user) {
         double id = Math.floor(Math.random() * 100);
        return insertUser(id,user);
    }

    List<User> getAllUsers();
}
