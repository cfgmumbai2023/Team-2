package com.mastercard.mdes.ecom.service;

import com.mastercard.mdes.ecom.dao.OrderDaoImpl;
import com.mastercard.mdes.ecom.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrdersService {
    @Autowired
    private OrderDaoImpl ordersDAOImpl;

    public boolean createOrder(Order orders) {
        return ordersDAOImpl.addOrder(orders);
    }

    public Optional<Order> getOrderDetails(String orderId) {
        Optional<Order> orderDetailsById = null;
        try{
            orderDetailsById = Optional.ofNullable(ordersDAOImpl.getOrder(orderId));
        }
        catch(Exception e){
            return null;
        }
        return orderDetailsById;
    }

    public List<Order> getOrderDetailsByCustomerId(String customerId) {
        List<Order> orderDetailsByCustomerId = null;
        try{
            orderDetailsByCustomerId = ordersDAOImpl.getOrdersByCustomerId(customerId);
        }
        catch(Exception e){
            return null;
        }
        return orderDetailsByCustomerId;
    }

    public boolean modifyOrder(Order orders) {
         return  ordersDAOImpl.updateOrder(orders);
    }

    public boolean deleteOrder(String orderId) {
        return ordersDAOImpl.deleteOrder(orderId);
    }

    public boolean deleteOrderByCustomerId(String customerId) {
        return ordersDAOImpl.deleteOrderByCustomerId(customerId);
    }
}
