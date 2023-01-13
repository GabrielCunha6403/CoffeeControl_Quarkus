package com.unifor.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SolicitationProductMapper {

    @Insert("INSERT INTO solicitation_product(solicitation_id, product_id, asked_amount)" +
            "VALUES(#{solicitation_id}, #{product_id}, #{asked_amount})")
    Integer saveSolicitationProduct(Long solicitation_id, Long product_id, Integer asked_amount);

}
