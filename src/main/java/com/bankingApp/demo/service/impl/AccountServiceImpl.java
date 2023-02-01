package com.bankingApp.demo.service.impl;

import com.bankingApp.demo.dao.AccountDao;
import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public void save(AccountModel accountModel) {
        accountDao.save(accountModel);
    }

    public List<AccountModel> listAll() {
        return accountDao.findAll();
    }

    public AccountModel get(int id) {
        return accountDao.get(id);
    }

    public void delete(int id) {
        accountDao.delete(id);
    }

    public Set<AccountModel> getInactiveAccountDetails() {
        return accountDao.getInactiveAccountDetails();
    }

    public Set<AccountModel> getActiveAccountDetails(int userId) {
        return accountDao.getActiveAccountDetails(userId);
    }

    public List<UserModel> getRegUserList() {
        return accountDao.getRegUserList();
    }
}
