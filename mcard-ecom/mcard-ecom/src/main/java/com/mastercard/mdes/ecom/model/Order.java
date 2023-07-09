package com.mastercard.mdes.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component

public class Order {
    private String orderId;

    private String customerId;

    private String productId;

    private long amount;

    private String couponCode;

    private LocalDate orderDate;

    private int quantity;
}
