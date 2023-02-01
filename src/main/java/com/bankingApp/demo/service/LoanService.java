package com.bankingApp.demo.service;

import com.bankingApp.demo.model.LoanModel;

import java.util.List;

public interface LoanService
{
    public void save(LoanModel loanModel);

    public List<LoanModel> listAll();

    public LoanModel get(int id);

    public void delete(int id);

    public List<LoanModel> findByStatus(String status);
}
