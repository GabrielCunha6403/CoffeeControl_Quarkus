package com.unifor.mappers;

import com.unifor.models.ContributionProduct;
import com.unifor.models.Storage;
import com.unifor.models.compositeKey.ContributionProductId;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContributionProductMapper {

    @Select("SELECT * FROM contribution_product")
    List<ContributionProduct> getContributionProducts();

    @Select("SELECT * FROM contribution_product WHERE id = #{id}")
    ContributionProduct getContributionProduct(Long id);

    @Insert("INSERT INTO contribution_product (contribution_id, " +
            "product_id, " +
            "amount_given " +
            "VALUES (" +
            "#{contribution_id}," +
            "#{product_id}," +
            "#{amount_given}")
    Integer saveContributionProduct(
            @Param("contribution_id") Integer contribution_id,
            @Param("product_id") Integer product_id,
            @Param("amount_given") Integer amount_given
    );

    @Delete("DELETE FROM contribution_product " +
            "WHERE contribution_id = #{id.contributionId " +
            "AND product_id = #{id.productId}")
    Integer deleteContributionProduct(ContributionProductId id);
}
