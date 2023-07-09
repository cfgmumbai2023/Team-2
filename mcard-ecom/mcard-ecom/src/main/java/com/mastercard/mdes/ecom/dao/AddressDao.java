package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Address;

import java.util.List;

public interface AddressDao {
    List<Address> getAddressByCustomerId(String customerId);
    Address getAddress(String addressId);
    boolean addAddress(Address address);
    boolean updateAddress(Address address);
    boolean deleteAddress(String customerId);
    boolean deleteAddressByCustomerId(String customerId);
}
