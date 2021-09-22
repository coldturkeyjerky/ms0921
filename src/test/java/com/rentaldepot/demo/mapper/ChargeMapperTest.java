package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.config.PersistenceConfig;
import com.rentaldepot.demo.model.Charge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class ChargeMapperTest {
    @Autowired
    ChargeMapper chargeMapper;

    @Test
    public void whenRecordsInDatabase_shouldReturnChargeWithGivenId() {
        Charge charge = chargeMapper.getCharge(1L);

        assertThat(charge).isNotNull();
        assertThat(charge.getId()).isEqualTo(1L);
        assertThat(charge.getType()).isEqualTo("Ladder");
        assertThat(charge.getDaily()).isEqualTo(1.99);
        assertThat(charge.getWeekday()).isTrue();
        assertThat(charge.getWeekend()).isTrue();
        assertThat(charge.getHoliday()).isFalse();
    }
}