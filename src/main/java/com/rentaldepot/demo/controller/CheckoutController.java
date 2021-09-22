package com.rentaldepot.demo.controller;

import com.google.common.base.Preconditions;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import com.rentaldepot.demo.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RentalAgreement> save(@RequestBody Checkout checkout) {
        Preconditions.checkNotNull(checkout);

        if (checkout.getDiscount_percent() > 100 || checkout.getDiscount_percent() < 0) {
            return ResponseEntity.badRequest().build();
        }

        service.saveCheckout(checkout);
        service.saveRentalAgreement(checkout);
        RentalAgreement agreement = service.findRentalAgreement(checkout);

        if (agreement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(agreement);
    }

}
