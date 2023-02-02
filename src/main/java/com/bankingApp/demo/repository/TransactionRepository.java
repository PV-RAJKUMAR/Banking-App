package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>
{

}
