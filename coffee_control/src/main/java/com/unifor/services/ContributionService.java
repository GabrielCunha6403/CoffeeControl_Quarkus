package com.unifor.services;

import com.unifor.dtos.ContributionDto;
import com.unifor.forms.ContributionPostForm;

import java.util.List;

public interface ContributionService {
    List<ContributionDto> list();

    ContributionDto getSpecificContribution(Long id);

    void saveContribution(ContributionPostForm form);
}
