package com.rentaldepot.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Checkout implements Serializable {
    private static final long serialVersionUID = -8115344784070789773L;

    private long id;
    private String toolCode;
    private int rentalDays;
    private int discountPercent;
    private LocalDate checkoutDate;

    public Checkout(long id, String toolCode, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        this.id = id;
        this.toolCode = toolCode;
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}