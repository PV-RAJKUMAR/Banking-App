package com.bankingApp.demo.dao;

import com.bankingApp.demo.model.UserModel;

import java.util.List;

public interface UserDao {
    public void save(UserModel user);

    public List<UserModel> findAll();

    public UserModel get(int id);

    public void delete(int id);

    public UserModel findByUserName(String userName);

    public UserModel findByUserId(int userId);
}
