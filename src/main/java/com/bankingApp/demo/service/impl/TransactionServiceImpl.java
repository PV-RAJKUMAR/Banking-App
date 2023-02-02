package com.bankingApp.demo.service.impl;

import com.bankingApp.demo.dao.AccountDao;
import com.bankingApp.demo.dao.TransactionDao;
import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.TransactionModel;
import com.bankingApp.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    TransactionDao transactionDao;

    public void save(TransactionModel transactionModel) {
        transactionDao.save(transactionModel);
    }

    public List<TransactionModel> listAll() {
        return transactionDao.findAll();
    }

    public TransactionModel get(int id) {
        return transactionDao.get(id);
    }

    public void delete(int id) {
        transactionDao.delete(id);
    }
}
