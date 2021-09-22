package com.rentaldepot.demo.model;

import java.util.Date;

public class Checkout {
    private Long id;
    private String tool_code;
    private int rental_days;
    private int discount_percent;
    private Date checkout_date;

    public Checkout(Long id, String tool_code, int rental_days, int discount_percent, Date checkout_date) {
        this.id = id;
        this.tool_code = tool_code;
        this.rental_days = rental_days;
        this.discount_percent = discount_percent;
        this.checkout_date = checkout_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTool_code() {
        return tool_code;
    }

    public void setTool_code(String tool_code) {
        this.tool_code = tool_code;
    }

    public int getRental_day_count() {
        return rental_days;
    }

    public void setRental_day_count(int rental_day_count) {
        this.rental_days = rental_day_count;
    }

    public int getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }
}
