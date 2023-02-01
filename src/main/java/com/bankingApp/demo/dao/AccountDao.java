package com.bankingApp.demo.dao;

import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.UserModel;

import java.util.List;
import java.util.Set;

public interface AccountDao {
    public void save(AccountModel accountModel);

    public List<AccountModel> findAll();

    public AccountModel get(int id);

    public void delete(int id);

    public Set<AccountModel> getInactiveAccountDetails();

    public List<UserModel> getRegUserList();

    public Set<AccountModel> getActiveAccountDetails(int userId);

}
