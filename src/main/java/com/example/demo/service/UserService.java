package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    //TODO: ADD MORE CLASS METHODS
    @Autowired
    public UserService(@Qualifier("postgres") UserDao userdao) {this.userDao = userdao;}
    public User addUser(User user) {return userDao.insertUser(user);}
    public List<User> getAllUsers() { return userDao.getAllUsers();}


}
