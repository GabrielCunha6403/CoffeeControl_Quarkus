package com.unifor.models;

import com.unifor.dtos.SolicitationDto;
import com.unifor.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {
    public Long id;
    public LocalDate contributionDate=LocalDate.now();
    public UserDto user;
    public SolicitationDto solicitation;
    public List<Product> products;

}
