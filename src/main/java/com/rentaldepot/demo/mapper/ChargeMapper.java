package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.Charge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChargeMapper {
    @Select("SELECT * from CHARGES where id = #{id}")
    Charge getCharge(@Param("id") Long id);
}
