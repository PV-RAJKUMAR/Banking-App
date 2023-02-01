package com.bankingApp.demo.service.impl;

import com.bankingApp.demo.dao.AddressDao;
import com.bankingApp.demo.model.AddressModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    public void save(AddressModel addressModel) {
        addressDao.save(addressModel);
    }

    public List<AddressModel> listAll() {
        return addressDao.findAll();
    }

    public AddressModel get(int id) {
        return addressDao.get(id);
    }

    public void delete(int id) {
        addressDao.delete(id);
    }

    public List<AddressModel> findAddressModels(int userId) {
        return addressDao.findAddressModels(userId);
    }
}
