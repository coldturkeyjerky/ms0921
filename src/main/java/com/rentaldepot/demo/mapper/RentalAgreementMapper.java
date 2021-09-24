package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.Checkout;
import com.rentaldepot.demo.model.RentalAgreement;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RentalAgreementMapper {
    public void saveAgreement(Checkout checkout);
    public List<RentalAgreement> findAgreement(Checkout checkout);
}
