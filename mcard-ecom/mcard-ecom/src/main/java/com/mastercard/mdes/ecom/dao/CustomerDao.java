package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    Customer getCustomerById(String id);
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id);
}
