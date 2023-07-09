package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Address;
import com.mastercard.mdes.ecom.model.Coupon;

import java.util.List;

public interface CouponDao {
    boolean addCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
