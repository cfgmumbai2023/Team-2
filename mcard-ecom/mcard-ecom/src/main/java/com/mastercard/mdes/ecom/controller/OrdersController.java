package com.mastercard.mdes.ecom.controller;


import com.mastercard.mdes.ecom.model.Order;
import com.mastercard.mdes.ecom.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordersAPI")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(Order orders){
        if(ordersService.createOrder(orders)){
            return new ResponseEntity<String>("Order placed successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error occurred while placing order",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modifyOrder")
    public ResponseEntity<String> modifyOrder(Order orders){
        if(ordersService.modifyOrder(orders)){
            return new ResponseEntity<String>("Order modified successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error occurred while modifying order",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderDetailsById/{orderId}")
    public ResponseEntity<Optional<Order>> getOrderDetailsById(@PathVariable("orderId") String orderId){
        Optional<Order> orderDetailsById = ordersService.getOrderDetails(orderId);
        if(orderDetailsById==null){
            return new ResponseEntity<Optional<Order>>(orderDetailsById,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<Optional<Order>>(orderDetailsById,HttpStatus.OK);
        }
    }

    @GetMapping("/getOrderDetailsById/{customerId}")
    public ResponseEntity<List<Order>> getOrderDetailsByCustomerId(@PathVariable("customerId") String customerId){
        List<Order> orderDetailsById = ordersService.getOrderDetailsByCustomerId(customerId);
        if(orderDetailsById==null){
            return new ResponseEntity<List<Order>>(orderDetailsById,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<List<Order>>(orderDetailsById,HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") String orderId){
        if(ordersService.deleteOrder(orderId)){
            return new ResponseEntity<String>("Order deleted by orderId successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error occurred while deleting order by orderId",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteOrder/{customerId}")
    public ResponseEntity<String> deleteOrderByCustomerId(@PathVariable("customerId") String customerId){
        if(ordersService.deleteOrderByCustomerId(customerId)){
            return new ResponseEntity<String>("Order deleted by customerId successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error occurred while deleting order by customerId",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
