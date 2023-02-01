package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
}
