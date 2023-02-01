package com.bankingApp.demo.service.impl;

import com.bankingApp.demo.dao.UserDao;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void save(UserModel user) {
        userDao.save(user);
    }

    public List<UserModel> listAll() {
        return userDao.findAll();
    }

    public UserModel get(int id) {
        return userDao.get(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public UserModel findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public UserModel findByUserId(int userId) {
        return userDao.findByUserId(userId);
    }
}
