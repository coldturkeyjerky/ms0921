package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.config.PersistenceConfig;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import com.rentaldepot.demo.util.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class MapperTest {
    @Autowired
    CheckoutMapper checkoutMapper;

    @Autowired
    RentalAgreementMapper rentalAgreementMapper;


    @Test
    public void testMapper_outOfBoundsPercent() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2015);
        cal1.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal1.set(Calendar.DAY_OF_MONTH, 3);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        // NOTE: this test is at the mapper level
        // At the controller level, an empty response is returned for percent > 100 OR percent < 0
        int days = 5;
        int percent = 101;
        String toolCode = "JAKR";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(3);
        // NOTE: this test is at the mapper level
        // At the controller level, an empty response is returned for percent > 100 OR percent < 0
        assertThat(agreement.getFinalCharge()).isEqualTo(-0.09);
    }

    @Test
    public void testMapper_independenceDayWithDiscountNoChargeTest() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2020);
        cal1.set(Calendar.MONTH, Calendar.JULY);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        int days = 3;
        int percent = 10;
        String toolCode = "LADW";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(0);
        assertThat(agreement.getFinalCharge()).isEqualTo(0.00);
    }

    @Test
    public void testMapper_independenceDayWithDiscountTest() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2015);
        cal1.set(Calendar.MONTH, Calendar.JULY);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        int days = 5;
        int percent = 25;
        String toolCode = "CHNS";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(2);
        assertThat(agreement.getFinalCharge()).isEqualTo(2.24);
    }

    @Test
    public void testMapper_laborDayWithoutDiscountTest() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2015);
        cal1.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal1.set(Calendar.DAY_OF_MONTH, 3);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        int days = 6;
        int percent = 0;
        String toolCode = "JAKD";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(4);
        assertThat(agreement.getFinalCharge()).isEqualTo(11.96);
    }

    @Test
    public void testMapper_independenceDayWithoutDiscountTest() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2015);
        cal1.set(Calendar.MONTH, Calendar.JULY);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        int days = 9;
        int percent = 0;
        String toolCode = "JAKR";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(6);
        assertThat(agreement.getFinalCharge()).isEqualTo(17.94);
    }

    @Test
    public void testMapper_independenceDayWithDiscountTest2() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2020);
        cal1.set(Calendar.MONTH, Calendar.JULY);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        LocalDate checkout_date = Function.convertToLocalDate(cal1.getTime());
        int days = 4;
        int percent = 50;
        String toolCode = "JAKR";

        Checkout checkout = new Checkout(1, toolCode, days, percent, checkout_date);
        checkoutMapper.saveCheckout(checkout);
        rentalAgreementMapper.saveAgreement(checkout);
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);

        assertThat(agreements).isNotNull();
        assertThat(agreements).isNotEmpty();

        RentalAgreement agreement = agreements.get(0);
        assertThat(agreement.getRentalDays()).isEqualTo(checkout.getRentalDays());
        assertThat(agreement.getDiscountPercent()).isEqualTo(checkout.getDiscountPercent());
        assertThat(agreement.getToolCode()).isEqualTo(checkout.getToolCode());
        assertThat(agreement.getCheckoutDate()).isEqualTo(checkout.getCheckoutDate());
        assertThat(agreement.getChargeDays()).isEqualTo(1);
        assertThat(agreement.getFinalCharge()).isEqualTo(1.5);
    }
}