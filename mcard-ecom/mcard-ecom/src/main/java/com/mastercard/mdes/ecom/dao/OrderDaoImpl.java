package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        String query = "SELECT * FROM orders WHERE customerId = ?";
        return jdbcTemplate.query(query, this::mapRowToOrder, new Object[]{customerId});
    }
    @Override
    public Order getOrder(String orderId) {
        String query = "SELECT * FROM orders WHERE customerId = ?";
        return jdbcTemplate.queryForObject(query, this::mapRowToOrder, orderId);
    }

    @Override
    public boolean addOrder(Order order) {
        try {
            String query = "INSERT INTO orders (productId, customerId, amount, couponCode, orderDate, quantity) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, order.getProductId(),
                    order.getCustomerId(), order.getAmount(), order.getCouponCode(), order.getOrderDate(), order.getQuantity());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            String query = "UPDATE orders SET productId = ?, customerId = ?, amount=?, couponCode=?, orderDate=?, quantity = ? " +
                    "WHERE orderId = ?";
            jdbcTemplate.update(query, order.getProductId(), order.getCustomerId(), order.getAmount(),
                    order.getCouponCode(), order.getOrderDate(), order.getQuantity(), order.getOrderId());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteOrder(String orderId) {
        try {
            String query = "DELETE FROM orders WHERE orderId = ?";
            jdbcTemplate.update(query, orderId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteOrderByCustomerId(String customerId) {
        try {
            String query = "DELETE FROM orders WHERE customerId = ?";
            jdbcTemplate.update(query, customerId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    private Order mapRowToOrder(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getString("orderId"));
        order.setProductId(resultSet.getString("productId"));
        order.setCustomerId(resultSet.getString("customerId"));
        order.setAmount(resultSet.getLong("amount"));
        order.setCouponCode(resultSet.getString("couponCode"));
        order.setOrderDate(resultSet.getDate("orderDate").toLocalDate());
        order.setQuantity(resultSet.getInt("quantity"));
        return order;
    }
}
