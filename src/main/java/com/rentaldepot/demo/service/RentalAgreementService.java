package com.rentaldepot.demo.service;

import com.rentaldepot.demo.mapper.RentalAgreementMapper;
import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RentalAgreementService {

    @Autowired
    RentalAgreementMapper rentalAgreementMapper;

    @Transactional
    public void saveRentalAgreement(Checkout checkout) {
        rentalAgreementMapper.saveAgreement(checkout);
    }

    public RentalAgreement findRentalAgreement(Checkout checkout) {
        List<RentalAgreement> agreements = rentalAgreementMapper.findAgreement(checkout);
        return agreements.get(0);
    }
}
