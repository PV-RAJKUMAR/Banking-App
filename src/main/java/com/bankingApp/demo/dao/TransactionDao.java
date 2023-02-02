package com.bankingApp.demo.dao;

import com.bankingApp.demo.model.TransactionModel;

import java.util.List;

public interface TransactionDao {
    public void save(TransactionModel transactionModel);

    public List<TransactionModel> findAll();

    public TransactionModel get(int id);

    public void delete(int id);
}
