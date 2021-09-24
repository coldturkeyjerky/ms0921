package com.rentaldepot.demo.config;

import com.rentaldepot.demo.service.CheckoutService;
import com.rentaldepot.demo.service.RentalAgreementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ServiceConfig {

    @Bean
    public CheckoutService checkoutService() {
        return new CheckoutService();
    }

    @Bean
    public RentalAgreementService rentalAgreementService() {
        return new RentalAgreementService();
    }
}
