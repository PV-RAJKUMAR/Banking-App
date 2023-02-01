package com.bankingApp.demo.dao;

import com.bankingApp.demo.model.LoanModel;

import java.util.List;

public interface LoanDao
{
    public void save(LoanModel loan);

    public List<LoanModel> findAll();

    public LoanModel get(int id);

    public void delete(int id);

    public List<LoanModel> findByStatus(String status);
}
