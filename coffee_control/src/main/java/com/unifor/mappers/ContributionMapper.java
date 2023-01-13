package com.unifor.mappers;

import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.SolicitationDto;
import com.unifor.models.Contribution;
import com.unifor.models.Product;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ContributionMapper {

    @Select("SELECT * FROM contributions")
    List<ContributionDto> getContributions();

    @Select("SELECT * FROM contributions WHERE id = #{id}")
    ContributionDto getContribution(Long id);

    @Insert("INSERT INTO contributions (id, contribution_date, user_id, solicitation_id) VALUES (DEFAULT, #{date}, #{user_id}, #{solicitation_id}")
    Integer saveContribution(@Param("date") LocalDate date, @Param("user_id") Long user_id, @Param("solicitation_id") Long solicitation_id);

    @Delete("DELETE FROM contributions WHERE id = #{id}")
    Integer deleteContribution(Long id);

    @Select("select p.* from products p " +
            "join contribution_product cp on p.id = cp.product_id " +
            "join contributions c on c.id = cp.contribution_id " +
            "where c.id = #{id}")
    List<Product> getListOfProducts(Long id);

    @Select("SELECT * FROM contributions WHERE id=(SELECT max(id) FROM contributions)")
    ContributionDto getLastContribution();
}
