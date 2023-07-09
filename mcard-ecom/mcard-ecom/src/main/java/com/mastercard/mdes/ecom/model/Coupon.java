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

public class Coupon {
    private String couponCode;
    private long discountPercentage;
    private LocalDate validTill;

}
