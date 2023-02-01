package com.bankingApp.demo.dao.impl;

import com.bankingApp.demo.dao.UserDao;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    public void save(UserModel user) {
        userRepository.save(user);
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public UserModel findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserModel findByUserId(int userId) {
        return userRepository.findByUserId(userId);
    }
}
