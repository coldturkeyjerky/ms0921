package com.rentaldepot.demo.service;

import com.google.common.base.Preconditions;
import com.rentaldepot.demo.mapper.CheckoutMapper;
import com.rentaldepot.demo.mapper.RentalAgreementMapper;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutService {

    @Autowired
    CheckoutMapper checkoutMapper;

    @Autowired
    RentalAgreementMapper rentalAgreementMapper;

    @Transactional
    public void saveCheckout(Checkout checkout) {
        Preconditions.checkNotNull(checkout.getCheckout_date());
        Preconditions.checkNotNull(checkout.getDiscount_percent());
        Preconditions.checkNotNull(checkout.getTool_code());
        Preconditions.checkNotNull(checkout.getRental_day_count());



        checkoutMapper.save(
                checkout.getTool_code(),
                checkout.getRental_day_count(),
                checkout.getDiscount_percent(),
                checkout.getCheckout_date());
    }

    @Transactional
    public RentalAgreement findRentalAgreement(Checkout checkout) {
        RentalAgreement agreement = rentalAgreementMapper.findAgreement(
                checkout.getTool_code(),
                checkout.getRental_day_count(),
                checkout.getDiscount_percent(),
                checkout.getCheckout_date());
        return agreement;
    }

    @Transactional
    public void saveRentalAgreement(Checkout checkout) {
        rentalAgreementMapper.save(
                checkout.getTool_code(),
                checkout.getRental_day_count(),
                checkout.getDiscount_percent(),
                checkout.getCheckout_date());
    }
}
