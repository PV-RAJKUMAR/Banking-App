package com.bankingApp.demo.dao.impl;

import com.bankingApp.demo.dao.AddressDao;
import com.bankingApp.demo.model.AddressModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Autowired
    AddressRepository addressRepository;

    public void save(AddressModel addressModel) {
        addressRepository.save(addressModel);
    }

    public List<AddressModel> findAll() {
        return addressRepository.findAll();
    }

    public AddressModel get(int id) {
        return addressRepository.findById(id).get();
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    public List<AddressModel> findAddressModels(int userId) {
        return addressRepository.findAddressModels(userId);
    }
}
