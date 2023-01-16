package com.unifor.dtos;

import com.unifor.mappers.SolicitationMapper;
import com.unifor.mappers.UserMapper;
import com.unifor.models.Solicitation;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class SolicitationDto {
    public Long id;
    public String name;
    public LocalDate date;
    public Boolean enable;
    public Long user_id;
    public LocalDate expiration;

    public Solicitation convert(SolicitationMapper mapper, UserMapper userMapper){

        Solicitation solicitation = new Solicitation(
                this.id,
                this.name,
                this.date,
                this.expiration,
                this.enable,
                userMapper.getUser(this.user_id),
                mapper.getListOfContributions(this.id),
                mapper.getListOfProducts(this.id)
                );
        return solicitation;
    }
}
