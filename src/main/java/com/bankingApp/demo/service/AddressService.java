package com.bankingApp.demo.service;

import com.bankingApp.demo.model.AddressModel;

import java.util.List;

public interface AddressService {
    public void save(AddressModel addressModel);

    public List<AddressModel> listAll();

    public AddressModel get(int id);

    public void delete(int id);

    public List<AddressModel> findAddressModels(int userId);
}
