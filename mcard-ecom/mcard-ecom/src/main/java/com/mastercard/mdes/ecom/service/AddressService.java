package com.mastercard.mdes.ecom.service;

import com.mastercard.mdes.ecom.dao.AddressDaoImpl;
import com.mastercard.mdes.ecom.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressService {
    @Autowired
    private AddressDaoImpl addressDAOImpl;

    public boolean addAddress(Address address) {
        return addressDAOImpl.addAddress(address);
    }

    public boolean updateAddress(Address address) {
        return addressDAOImpl.updateAddress(address);
    }

    public List<Address> getAddressByCustomerId(String customerId) {
        List<Address> addressList = null;
        try{
            addressList = addressDAOImpl.getAddressByCustomerId(customerId);
        }
        catch( Exception e){
            return null;
        }
        return addressList;
    }
    public Address getAddressByAddressId(String addressId) {
        Address address = null;
        try{
            address = addressDAOImpl.getAddress(addressId);
        }
        catch( Exception e){
            return null;
        }
        return address;
    }

    public boolean deleteAddressByCustomerId(String customerId) {
        return addressDAOImpl.deleteAddressByCustomerId(customerId);
    }

    public boolean deleteAddressByAddressId(String addressId) {
        return addressDAOImpl.deleteAddress(addressId);
    }
}
