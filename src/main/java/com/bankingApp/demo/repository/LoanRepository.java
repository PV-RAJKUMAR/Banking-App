package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanModel, Integer> {

    List<LoanModel> findByStatus(String status);
}
