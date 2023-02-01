package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByUserName(String userName);

    UserModel findByUserId(int userId);
}
