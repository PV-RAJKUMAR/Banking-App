package com.bankingApp.demo.dao.impl;

import com.bankingApp.demo.dao.AccountDao;
import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class AccountDaoImpl implements AccountDao {
    @Autowired
    AccountRepository accountRepository;

    public void save(AccountModel accountModel) {
        accountRepository.save(accountModel);
    }

    public List<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    public AccountModel get(int id) {
        return accountRepository.findById(id).get();
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    public Set<AccountModel> getInactiveAccountDetails() {
        return accountRepository.getInactiveAccountDetails();
    }

    public Set<AccountModel> getActiveAccountDetails(int userId) {
        return accountRepository.getActiveAccountDetails(userId);
    }

    public List<UserModel> getRegUserList() {
        return accountRepository.getRegUserList();
    }
}
