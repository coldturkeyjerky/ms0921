package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.Checkout;

import java.util.List;

public interface CheckoutMapper {
    public void saveCheckout(Checkout checkout);
    public List<Checkout> findCheckout(Checkout checkout);
}
