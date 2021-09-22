package com.rentaldepot.demo.model;

import java.util.Date;

/**
 * WIP:
 SELECT tools.tool_code, tools.tool_type, tools.tool_brand, checkouts.discount_percent, checkouts.rental_days, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date), charges.daily_charge, GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)), GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge, checkouts.discount_percent, (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100), (GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge)  - ((GET_CHARGE_DAYS(charges.weekday_charge, charges.weekend_charge, charges.holiday_charge, checkouts.checkout_date, DATEADD('day', checkouts.rental_days, checkouts.checkout_date)) * charges.daily_charge) * (checkouts.discount_percent / 100))   FROM tools
 INNER JOIN checkouts
 ON tools.tool_code = checkouts.tool_code
 INNER JOIN charges
 ON tools.tool_type = charges.tool_type;

 */


public class RentalAgreement {
    private Long id;
    private String tool_code;
    private String tool_type;
    private String tool_brand;
    private int rental_days;
    private Date checkout_date;
    private Date due_date;
    private double daily_rental_charge;
    private int charge_days;
    private double pre_discount_charge;
    private int discount_percent;
    private double discount_amount;
    private double final_charge;

    public RentalAgreement() {
    }

    public RentalAgreement(Long id, String tool_code, String tool_type, String tool_brand, int rental_days, Date checkout_date, Date due_date, double daily_rental_charge, int charge_days, double pre_discount_charge, int discount_percent, double discount_amount, double final_charge) {
        this.id = id;
        this.tool_code = tool_code;
        this.tool_type = tool_type;
        this.tool_brand = tool_brand;
        this.rental_days = rental_days;
        this.checkout_date = checkout_date;
        this.due_date = due_date;
        this.daily_rental_charge = daily_rental_charge;
        this.charge_days = charge_days;
        this.pre_discount_charge = pre_discount_charge;
        this.discount_percent = discount_percent;
        this.discount_amount = discount_amount;
        this.final_charge = final_charge;
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

    public String getTool_type() {
        return tool_type;
    }

    public void setTool_type(String tool_type) {
        this.tool_type = tool_type;
    }

    public String getTool_brand() {
        return tool_brand;
    }

    public void setTool_brand(String tool_brand) {
        this.tool_brand = tool_brand;
    }

    public int getRental_days() {
        return rental_days;
    }

    public void setRental_days(int rental_days) {
        this.rental_days = rental_days;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public double getDaily_rental_charge() {
        return daily_rental_charge;
    }

    public void setDaily_rental_charge(double daily_rental_charge) {
        this.daily_rental_charge = daily_rental_charge;
    }

    public int getCharge_days() {
        return charge_days;
    }

    public void setCharge_days(int charge_days) {
        this.charge_days = charge_days;
    }

    public double getPre_discount_charge() {
        return pre_discount_charge;
    }

    public void setPre_discount_charge(double pre_discount_charge) {
        this.pre_discount_charge = pre_discount_charge;
    }

    public int getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }

    public double getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }

    public double getFinal_charge() {
        return final_charge;
    }

    public void setFinal_charge(double final_charge) {
        this.final_charge = final_charge;
    }

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "id=" + id +
                ", tool_code='" + tool_code + '\'' +
                ", tool_type='" + tool_type + '\'' +
                ", tool_brand='" + tool_brand + '\'' +
                ", rental_days=" + rental_days +
                ", checkout_date=" + checkout_date +
                ", due_date=" + due_date +
                ", daily_rental_charge=" + daily_rental_charge +
                ", charge_days=" + charge_days +
                ", pre_discount_charge=" + pre_discount_charge +
                ", discount_percent=" + discount_percent +
                ", discount_amount=" + discount_amount +
                ", final_charge=" + final_charge +
                '}';
    }
}
