package com.unifor.services.impl;

import com.unifor.dtos.ContributionDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.mappers.ContributionMapper;
import com.unifor.mappers.ProfileMapper;
import com.unifor.mappers.SolicitationMapper;
import com.unifor.mappers.UserMapper;
import com.unifor.models.Solicitation;
import com.unifor.models.User;
import com.unifor.services.ContributionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ContributionServiceImpl implements ContributionService {
    @Inject
    ContributionMapper contributionMapper;

    @Inject
    UserMapper userMapper;

    @Inject
    ProfileMapper profileMapper;

    @Inject
    SolicitationMapper solicitationMapper;

    public List<ContributionDto> list(){
        return contributionMapper.getContributions();
    }

    @Override
    public ContributionDto getSpecificContribution(Long id) {
        return contributionMapper.getContribution(id);
    }

    @Override
    public void saveContribution(ContributionPostForm form) {
        User user = userMapper.getUser(form.user_id).convert(profileMapper);
        Solicitation solicitation = solicitationMapper.getSolicitation(form.solicitation_id);
    }
}
