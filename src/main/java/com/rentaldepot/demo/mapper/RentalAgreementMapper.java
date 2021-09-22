package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.RentalAgreement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface RentalAgreementMapper {

    @Insert("INSERT INTO rental_agreements (tool_code, tool_type, tool_brand, rental_days, checkout_date, due_date, daily_rental_charge, charge_days, pre_discount_charge, discount_percent, discount_amount, final_charge)\n" +
            "SELECT tools.tool_code, tools.tool_type, tools.tool_brand, checkouts.rental_days, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date), charges.daily_charge, GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)), GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge, checkouts.discount_percent, (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100), (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge)  - ((GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100))   FROM tools\n" +
            "INNER JOIN checkouts\n" +
            "ON tools.tool_code = checkouts.tool_code\n" +
            "INNER JOIN charges\n" +
            "ON tools.tool_type = charges.tool_type\n" +
            "WHERE checkouts.tool_code = #{tool_code} AND checkouts.rental_days = #{rental_days} AND checkouts.discount_percent = #{discount_percent} AND checkouts.checkout_date = #{checkout_date}")
    public void save(@Param("tool_code") String tool_code,
                     @Param("rental_days") int rental_days,
                     @Param("discount_percent") int discount_percent,
                     @Param("checkout_date") Date checkout_date);

   @Select("SELECT tools.tool_code, tools.tool_type, tools.tool_brand, checkouts.rental_days, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date), charges.daily_charge, GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)), GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge, checkouts.discount_percent, (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100), (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge)  - ((GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100))   FROM tools\n" +
           "INNER JOIN checkouts\n" +
           "ON tools.tool_code = checkouts.tool_code\n" +
           "INNER JOIN charges\n" +
           "ON tools.tool_type = charges.tool_type\n" +
           "WHERE checkouts.tool_code = #{tool_code} AND checkouts.rental_days = #{rental_days} AND checkouts.discount_percent = #{discount_percent} AND checkouts.checkout_date = #{checkout_date}")
   public RentalAgreement findAgreement(@Param("tool_code") String tool_code,
                                        @Param("rental_days") int rental_days,
                                        @Param("discount_percent") int discount_percent,
                                        @Param("checkout_date") Date checkout_date);
}
