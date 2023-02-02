package com.bankingApp.demo.dao.impl;

import com.bankingApp.demo.dao.TransactionDao;
import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.TransactionModel;
import com.bankingApp.demo.repository.AccountRepository;
import com.bankingApp.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Autowired
    TransactionRepository transactionRepository;

    public void save(TransactionModel transactionModel) {
        transactionRepository.save(transactionModel);
    }

    public List<TransactionModel> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionModel get(int id) {
        return transactionRepository.findById(id).get();
    }

    public void delete(int id) {
        transactionRepository.deleteById(id);
    }
}
