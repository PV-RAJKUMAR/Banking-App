package com.bankingApp.demo.service;

import com.bankingApp.demo.model.TransactionModel;

import java.util.List;

public interface TransactionService
{
    public void save(TransactionModel transactionModel);

    public List<TransactionModel> listAll();

    public TransactionModel get(int id);

    public void delete(int id);
}
