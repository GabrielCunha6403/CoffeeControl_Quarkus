package com.unifor.models;


import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solicitation {
    public Long id;
    public String name;
    public LocalDate solicitation_date=LocalDate.now();
    public LocalDate solicitation_expiration;
    public Boolean enabled=true;
    public UserDto assignedUser;
    public List<ContributionDto> contributions;
    public List<Product> products;
    

}
