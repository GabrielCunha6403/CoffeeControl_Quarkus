package com.unifor.mappers;

import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.SolicitationDto;
import com.unifor.models.Contribution;
import com.unifor.models.Product;
import com.unifor.models.Solicitation;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SolicitationMapper {

    @Select("SELECT * FROM solicitations")
    List<SolicitationDto> getSolicitations();

    @Select("SELECT * FROM solicitations WHERE id = #{id}")
    SolicitationDto getSolicitation(Long id);

    @Select("select * from products p " +
            "join solicitation_product sp on p.id = sp.product_id " +
            "where p.id = #{id};")
    List<Product> getProductList(Long id);

    @Insert("INSERT INTO solicitations (id, " +
            "solicitation_name, " +
            "solicitation_date, " +
            "enabled, " +
            "assigned_user_id, " +
            "solicitation_expiration) " +
            "VALUES (" +
            "DEFAULT, " +
            "#{name}, " +
            "#{date}, " +
            "#{enabled}, " +
            "#{user_id}, " +
            "#{expiration})")
    Integer saveSolicitation(
            @Param("name") String solicitation_name,
            @Param("date") LocalDate date,
            @Param("enabled") Boolean enabled,
            @Param("user_id") Long user_id,
            @Param("expiration") LocalDate expiration
            );

    @Delete("DELETE FROM solicitations WHERE id = #{id}")
    Integer deleteSolicitation(Long id);

    @Select("select * from products p " +
            "join solicitation_product sp on sp.product_id = p.id " +
            "join solicitations s on sp.solicitation_id = s.id " +
            "where s.id = #{id}")
    List<Product> getListOfProducts(Long id);

    @Select("select c.* from contributions c " +
            "join solicitations s on c.solicitation_id = s.id " +
            "where s.id = #{id}")
    List<ContributionDto> getListOfContributions(Long id);

    @Select("SELECT * FROM solicitations WHERE id=(SELECT max(id) FROM solicitations)")
    SolicitationDto getLastSolicitation();

    @Update("UPDATE solicitations SET enabled = true WHERE id = #{id}")
    SolicitationDto setEnable(Long id);

    @Update("UPDATE solicitations SET enabled = false WHERE id = #{id}")
    SolicitationDto setDisable(Long id);
}
