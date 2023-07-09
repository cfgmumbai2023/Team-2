package com.mastercard.mdes.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component

public class Customer {
    private String customerId;
    private String customerName;
    private long contactNumber;
    private String email_id;
    private int yearsOfExperience;
    private String license;
    private String gamePlay;



}


