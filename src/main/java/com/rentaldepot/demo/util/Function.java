package com.rentaldepot.demo.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 * Custom functions / stored procedures are not supported in H2, so we will reference
 * user defined functions here.
 *
 * Reference: https://www.h2database.com/html/features.html#user_defined_functions
 */
public class Function {

    /**
     * GET_CHARGE_DAYS
     *
     * @param weekday_charge -- whether the daily charge applies for weekdays
     * @param weekend_charge -- whether the daily charge applies for weekends
     * @param holiday_charge -- whether the daily charge applies for holidays
     * @param checkout -- day the tool was checked out
     * @param due -- day the tool is to be returned
     * @return charge days from the day after checkout through, and including, the due date
     */
    public static int getChargeDays(boolean weekday_charge, boolean weekend_charge, boolean holiday_charge,
                                    Date checkout, Date due) {
        final LocalDate checkout_date = convertToLocalDate(checkout);
        final LocalDate due_date = convertToLocalDate(due);

        int chargeDays = checkout_date.datesUntil(due_date).mapToInt(day -> {
            if (day.isEqual(checkout_date)) {
                return 0;
            }
            // Looking to compute number of days to charge for the tool
            if (!holiday_charge) {
                if (isLaborDay(day)) {
                    return 0;
                }
                // The logic throws me off a bit here.
                //
                // For example:
                // Can a tool be checked out on a holiday?
                // Can a tool be returned on a holiday?
                // For now, I think I will try avoiding these areas of ambiguity.
                //
                // In industrial software, these corner cases would need to be addressed.
                if (isIndependenceDay(day)) {
                    if (day.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                        // account for the coming weekday with a holiday discount
                        if (day.isBefore(due_date)) {
                            return -1;
                        }
                    }
                    else if (day.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                        // account for the past weekday with a holiday discount
                        if (day.isAfter(checkout_date)) {
                            return -1;
                        }
                    }
                    // Weekday holiday
                    else {
                        return 0;
                    }
                }
            }
            else if (isWeekend(day) && !weekend_charge) {
                return 0;
            }
            else if (!isWeekend(day) && !weekday_charge) {
                return 0;
            }
            return 1;
        }).sum();
        return chargeDays;
    }

    /**
     * https://www.baeldung.com/java-date-to-localdate-and-localdatetime#java9-conversion
     *
     * @param dateToConvert
     * @return
     */
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault()
        );
    }

    public static boolean isLaborDay(LocalDate day) {
        if (day.getMonth().equals(Month.SEPTEMBER) && day.getDayOfMonth() <= 7
                && day.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            return true;
        }
        return false;
    }

    public static boolean isIndependenceDay(LocalDate day) {
        if (day.getMonth() == Month.JULY && day.getDayOfMonth() == 4) {
            return true;
        }
        return false;
    }

    public static boolean isWeekend(LocalDate day) {

        if (day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        }
        return false;
    }
}
