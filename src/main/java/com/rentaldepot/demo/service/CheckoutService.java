package com.rentaldepot.demo.service;

import com.rentaldepot.demo.mapper.CheckoutMapper;
import com.rentaldepot.demo.model.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
