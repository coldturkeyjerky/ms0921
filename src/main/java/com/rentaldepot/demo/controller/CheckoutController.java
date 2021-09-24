package com.rentaldepot.demo.controller;

import com.google.common.base.Preconditions;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import com.rentaldepot.demo.service.CheckoutService;
import com.rentaldepot.demo.service.RentalAgreementService;
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
    private CheckoutService checkoutService;

    @Autowired
    private RentalAgreementService rentalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RentalAgreement> save(@RequestBody Checkout checkout) {
        Preconditions.checkNotNull(checkout);

        if (checkout.getDiscountPercent() > 100 || checkout.getDiscountPercent() < 0) {
            return ResponseEntity.badRequest().build();
        }

        checkoutService.saveCheckout(checkout);
        rentalService.saveRentalAgreement(checkout);
        RentalAgreement agreementResponse = rentalService.findRentalAgreement(checkout);
        if (agreementResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(agreementResponse);
    }

}
