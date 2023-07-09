package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Address;
import com.mastercard.mdes.ecom.model.Customer;
import com.mastercard.mdes.ecom.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        String query = "SELECT * FROM customers";
        return jdbcTemplate.query(query, this::mapRowToCustomer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        String query = "SELECT * FROM customers WHERE customerId = ?";
        return jdbcTemplate.queryForObject(query, this::mapRowToCustomer, customerId);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customers (customerId,customerName, contactNo,email_Id,yearsOfExperience,license,gamePlay) VALUES (?, ?,?,?,?,?,?)";
            jdbcTemplate.update(query, customer.getCustomerId(),customer.getCustomerName(), customer.getContactNumber(), customer.getEmail_id(),
                    customer.getYearsOfExperience(), customer.getLicense(), customer.getGamePlay());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            String query = "UPDATE customers SET customerName = ? contactNo= ? email_Id=? yearsOfExperience=? license=? gamePlay=? WHERE customerId = ?";
            jdbcTemplate.update(query, customer.getCustomerName(), customer.getContactNumber(), customer.getCustomerId());
            }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        try {
            String query = "DELETE FROM customers WHERE customerId = ?";
            jdbcTemplate.update(query, customerId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    private Customer mapRowToCustomer(ResultSet resultSet, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getString("customerId"));
        customer.setCustomerName(resultSet.getString("customerName"));
        customer.setContactNumber(resultSet.getLong("contactNo"));
        customer.setEmail_id(resultSet.getString("emailId"));
        customer.setYearsOfExperience(resultSet.getInt("license"));
        customer.setGamePlay(resultSet.getString("gamePlay"));
        return customer;
    }
}
