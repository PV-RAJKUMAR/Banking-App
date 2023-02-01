package com.bankingApp.demo.service.impl;

import com.bankingApp.demo.dao.LoanDao;
import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.LoanModel;
import com.bankingApp.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanDao loanDao;

    public void save(LoanModel loanModel) {
        loanDao.save(loanModel);
    }

    public List<LoanModel> listAll() {
        return loanDao.findAll();
    }

    public LoanModel get(int id) {
        return loanDao.get(id);
    }

    public void delete(int id) {
        loanDao.delete(id);
    }

    public List<LoanModel> findByStatus(String status) {
        return loanDao.findByStatus(status);
    }

}
