package com.mastercard.mdes.ecom.service;


import com.mastercard.mdes.ecom.dao.CouponDaoImpl;
import com.mastercard.mdes.ecom.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CouponService {
    @Autowired
    private CouponDaoImpl couponDAOImpl;

    public List<Coupon> getAllCoupons() {
        List<Coupon> couponList = couponDAOImpl.getAllCoupons();
        return couponList;
    }

    public boolean addCoupon(Coupon coupon) {
        return couponDAOImpl.addCoupon(coupon);
    }
}
