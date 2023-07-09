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

public class Product {
    private String productId;
    private String productName;
    private String model;
    private String category;
    private String manufacturer;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private long price;
}
