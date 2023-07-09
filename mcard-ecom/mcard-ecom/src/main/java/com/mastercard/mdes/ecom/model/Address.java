package com.mastercard.mdes.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Address {
    private String addressId;
    private String customerId;
    private String city;
    private String state;
    private String country;
    private long zipCode;


}
