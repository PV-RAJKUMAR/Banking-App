package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    @Query("select u From AccountModel u WHERE u.accountNo is null")
    Set<AccountModel> getInactiveAccountDetails();

    @Query("select distinct u.user From AccountModel u WHERE u.accountNo is not null ")
    List<UserModel>getRegUserList();

    @Query("select u From AccountModel u WHERE u.accountNo is not null and u.user.userId =:n")
    Set<AccountModel> getActiveAccountDetails(@Param("n") int userId);
}
