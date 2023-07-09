package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrdersByCustomerId(String customerId);
    Order getOrder(String orderId);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(String orderId);
    boolean deleteOrderByCustomerId(String customerId);
}
