package com.unifor.mappers;

import com.unifor.models.SolicitationProduct;
import com.unifor.models.compositeKey.SolicitationProductId;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SolicitationProductMapper {

    @Select("SELECT * FROM solicitation_product")
    List<SolicitationProduct> getSolicitationProducts();

    @Select("SELECT * FROM solicitation_product WHERE id = #{id}")
    SolicitationProduct getSolicitationProduct(Long id);

    @Insert("INSERT INTO solicitation_product (solicitation_id, " +
            "product_id, " +
            "asked_amount " +
            "VALUES (" +
            "#{contribution_id}," +
            "#{product_id}," +
            "#{asked_amount}")
    Integer saveSolicitationProduct(
            @Param("solicitation_id") Integer solicitation_id,
            @Param("product_id") Integer product_id,
            @Param("asked_amount") Integer asked_amount
    );
    @Delete("DELETE FROM solicitation_product " +
            "WHERE solicitation_id = #{id.solicitationId " +
            "AND product_id = #{id.productId}")
    Integer deleteContributionProduct(SolicitationProductId id);

    @Select("""
            SELECT EXISTS (SELECT 1 FROM solicitation_product sp 
            WHERE sp.solicitation_id= #{solicitationId} 
            AND sp.product_id = #{productId} )""")
    Boolean checkIfProductExistsInSolicitation(Long solicitationId, Long productId);
}
