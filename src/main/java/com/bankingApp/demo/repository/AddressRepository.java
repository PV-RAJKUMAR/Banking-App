package com.bankingApp.demo.repository;

import com.bankingApp.demo.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer>
{
    @Query("select u From AddressModel u WHERE u.user.userId =:n")
    List<AddressModel> findAddressModels(@Param("n") int userId);
}
