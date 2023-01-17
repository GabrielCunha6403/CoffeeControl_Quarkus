package com.unifor.dtos;

import java.time.LocalDate;

public class ContributionLightDto {
    public Long id;
    public LocalDate contributionDate=LocalDate.now();
    public Long solicitation_id;
}
