package com.unifor.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContributionProductMapper {

    @Insert("INSERT INTO contribution_product(contribution_id, product_id, amount_given) " +
            "VALUES(#{contribution_id}, #{product_id}, #{amount_given})")
    Integer saveContributionProduct(Long contribution_id, Long product_id, Integer amount_given);
}
