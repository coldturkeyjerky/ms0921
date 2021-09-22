package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
class CheckoutMapperTest {
    @Autowired
    CheckoutMapper checkoutMapper;

    @Test
    public void whenRecordsInDatabase_doStuff() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2015);
        cal1.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal1.set(Calendar.DAY_OF_MONTH, 3);
        Date checkout_date = cal1.getTime();
        checkoutMapper.save("JAKR", 5, 101, checkout_date);

    }

}