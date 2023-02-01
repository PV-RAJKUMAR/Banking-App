package com.bankingApp.demo.dao.impl;

import com.bankingApp.demo.dao.LoanDao;
import com.bankingApp.demo.model.LoanModel;
import com.bankingApp.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoanDaoImpl implements LoanDao {
    @Autowired
    LoanRepository loanRepository;

    public void save(LoanModel loan) {
        loanRepository.save(loan);
    }

    public List<LoanModel> findAll() {
        return loanRepository.findAll();
    }

    public LoanModel get(int id) {
        return loanRepository.findById(id).get();
    }

    public void delete(int id) {
        loanRepository.deleteById(id);
    }

    public List<LoanModel> findByStatus(String status) {
        return loanRepository.findByStatus(status);
    }

}
