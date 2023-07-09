package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Address> getAddressByCustomerId(String customerId) {
        String query = "SELECT * FROM addresses WHERE customerId = ?";
        return jdbcTemplate.query(query, this::mapRowToAddress, new Object[]{customerId});
    }
    @Override
    public Address getAddress(String addressId) {
        String query = "SELECT * FROM addresses WHERE addressId = ?";
        return jdbcTemplate.queryForObject(query, this::mapRowToAddress, addressId);
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            String query = "INSERT INTO addresses (customerId, city, state, country, zipCode) " +
                    "VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, address.getCustomerId(), address.getCity(),
                    address.getState(), address.getCountry(), address.getZipCode());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAddress(Address address) {
        try {
            String query = "UPDATE addresses SET city = ?, state = ?, country= ?, zipCode = ? " +
                    "WHERE addressId = ?";
            jdbcTemplate.update(query, address.getCity(), address.getState(), address.getCountry(),
                    address.getZipCode(), address.getAddressId());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAddress(String addressId) {
        try {
            String query = "DELETE FROM addresses WHERE addressId = ?";
            jdbcTemplate.update(query, addressId);
        }
        catch (Exception e){
            return false;
        }
        return true;

    }
    @Override
    public boolean deleteAddressByCustomerId(String customerId) {
        try {
            String query = "DELETE FROM addresses WHERE customerId = ?";
            jdbcTemplate.update(query, customerId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }


    private Address mapRowToAddress(ResultSet resultSet, int rowNum) throws SQLException {
        Address address = new Address();
        address.setAddressId(resultSet.getString("addressId"));
        address.setCustomerId(resultSet.getString("customerId"));
        address.setCity(resultSet.getString("city"));
        address.setState(resultSet.getString("state"));
        address.setCountry(resultSet.getString("country"));
        address.setZipCode(resultSet.getLong("zipCode"));
        return address;
    }
}
