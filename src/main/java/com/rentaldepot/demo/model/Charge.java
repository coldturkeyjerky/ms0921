package com.rentaldepot.demo.model;

public class Charge {
    private Long id;
    private String type;
    private double daily;
    private boolean weekday;
    private boolean weekend;
    private boolean holiday;

    public Charge(Long id, String type, double daily, boolean weekday, boolean weekend, boolean holiday) {
        this.id = id;
        this.type = type;
        this.daily = daily;
        this.weekday = weekday;
        this.weekend = weekend;
        this.holiday = holiday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public boolean getWeekday() {
        return weekday;
    }

    public void setWeekday(boolean weekday) {
        this.weekday = weekday;
    }

    public boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public boolean getHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }
}
