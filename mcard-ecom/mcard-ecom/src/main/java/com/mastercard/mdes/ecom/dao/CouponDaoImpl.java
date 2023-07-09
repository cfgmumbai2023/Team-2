package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CouponDaoImpl implements CouponDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addCoupon(Coupon coupon) {
        try {
            String query = "INSERT INTO coupons (couponCode, discountPercentage, validTill) VALUES (?, ?, ?)";
            jdbcTemplate.update(query, coupon.getCouponCode(), coupon.getDiscountPercentage(), coupon.getValidTill());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        String query = "SELECT * FROM coupons";
        return jdbcTemplate.query(query, this::mapRowToCoupon);
    }
    private Coupon mapRowToCoupon(ResultSet resultSet, int rowNum) throws SQLException {
        Coupon coupon = new Coupon();
        coupon.setCouponCode(resultSet.getString("couponCode"));
        coupon.setDiscountPercentage(resultSet.getLong("discountPercentage"));
        coupon.setValidTill(resultSet.getDate("validTill").toLocalDate());
        return coupon;
    }
}
