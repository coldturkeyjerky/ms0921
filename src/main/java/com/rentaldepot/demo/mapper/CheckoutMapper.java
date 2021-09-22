package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.RentalAgreement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface CheckoutMapper {
    @Insert("INSERT INTO checkouts(tool_code, rental_days, discount_percent, checkout_date) VALUES (#{tool_code}, #{rental_days}, #{discount_percent}, #{checkout_date})")
    public void save(@Param("tool_code") String tool_code,
                     @Param("rental_days") int rental_days,
                     @Param("discount_percent") int discount_percent,
                     @Param("checkout_date") Date checkout_date);


}
