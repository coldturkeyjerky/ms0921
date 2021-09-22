package com.rentaldepot.demo.mapper;

import com.rentaldepot.demo.model.Tool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ToolMapper {
    @Select("SELECT * from TOOLS where id = *{code}")
    Tool getTool(@Param("code") String code);
}
