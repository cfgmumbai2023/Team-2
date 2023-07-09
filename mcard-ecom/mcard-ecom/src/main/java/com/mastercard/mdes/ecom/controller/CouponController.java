package com.mastercard.mdes.ecom.controller;


import com.mastercard.mdes.ecom.model.Coupon;
import com.mastercard.mdes.ecom.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/addCoupon")
    public ResponseEntity<String> addCoupon(Coupon coupon){
        if(couponService.addCoupon(coupon)){
            return new ResponseEntity<String>("Coupon details saved successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred while adding coupon details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCoupons")
    public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> couponList = null;
        couponList = couponService.getAllCoupons();
        if(couponList==null){
            return new ResponseEntity<List<Coupon>>(couponList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<List<Coupon>>(couponList,HttpStatus.OK);
        }
    }
}
