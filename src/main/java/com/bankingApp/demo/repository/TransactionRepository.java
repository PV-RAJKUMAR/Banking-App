package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
    @Query("select u From TransactionModel u WHERE u.accountModel.user.userId =:n")
    List<TransactionModel> findUserTransactionList(@Param("n") int userId);
}
