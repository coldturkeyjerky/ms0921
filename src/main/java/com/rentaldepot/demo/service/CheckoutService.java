package com.rentaldepot.demo.service;

import com.google.common.base.Preconditions;
import com.rentaldepot.demo.mapper.CheckoutMapper;
import com.rentaldepot.demo.mapper.RentalAgreementMapper;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class CheckoutService {

    @Autowired
    CheckoutMapper checkoutMapper;

    @Transactional
    public void saveCheckout(Checkout checkout) {
        checkoutMapper.saveCheckout(checkout);
    }

    public Checkout findCheckout(Checkout checkout) {
        List<Checkout> response = checkoutMapper.findCheckout(checkout);
        return response.get(0);
    }


}
