package com.unifor.mappers;

import com.unifor.models.Contribution;
import com.unifor.models.Solicitation;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SolicitationMapper {

    @Select("SELECT * FROM solicitations")
    List<Solicitation> getSolicitations();

    @Select("SELECT * FROM solicitations WHERE id = #{id}")
    Solicitation getSolicitation(Long id);

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
            "#{expiration}")
    Integer saveSolicitation(
            @Param("name") String solicitation_name,
            @Param("date") LocalDate date,
            @Param("enabled") Boolean enabled,
            @Param("user_id") Integer user_id,
            @Param("expiration") LocalDate expiration
            );

    @Delete("DELETE FROM solicitations WHERE id = #{id}")
    Integer deleteSolicitation(Long id);
}
