package com.unifor.dtos;

import com.unifor.models.Solicitation;
import com.unifor.models.User;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ContributionDto {
    public Long id;
    public LocalDate contributionDate=LocalDate.now();
    public Long user_id;
    public Long solicitation_id;
}
