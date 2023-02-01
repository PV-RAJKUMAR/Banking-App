package com.bankingApp.demo.dao;

import com.bankingApp.demo.model.AddressModel;

import java.util.List;

public interface AddressDao {
    public void save(AddressModel addressModel);

    public List<AddressModel> findAll();

    public AddressModel get(int id);

    public void delete(int id);

    public List<AddressModel> findAddressModels(int userId);
}
