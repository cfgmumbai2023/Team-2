package com.mastercard.mdes.ecom.service;
import com.mastercard.mdes.ecom.dao.CustomerDaoImpl;
import com.mastercard.mdes.ecom.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDaoImpl customerDAOImpl;

    public boolean saveCustomer(Customer customer) {
        return customerDAOImpl.addCustomer(customer);
    }

    public boolean modifyCustomer(Customer customer) {
         return  customerDAOImpl.updateCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = null;
        try{
            customerList = customerDAOImpl.getAllCustomers();
        }
        catch( Exception e){
            return null;
        }
        return customerList;
    }

    public Optional<Customer> getCustomerById(String customerId) {
        Optional<Customer> customerDetailsById = null;
        try{
            customerDetailsById = Optional.ofNullable(customerDAOImpl.getCustomerById(customerId));
        }
        catch (Exception e){
            return null;
        }
        return customerDetailsById;
    }

    public boolean deleteCustomerDetails(String customerId) {
        return customerDAOImpl.deleteCustomer(customerId);
    }
}
