package com.unifor.services.impl;

import com.unifor.dtos.ContributionDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.mappers.*;
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

    @Inject
    ContributionProductMapper contributionProductMapper;

    public List<ContributionDto> list(){
        return contributionMapper.getContributions();
    }

    @Override
    public ContributionDto getSpecificContribution(Long id) {
        return contributionMapper.getContribution(id);
    }

    @Override
    public ContributionDto saveContribution(ContributionPostForm form, Long id) {
        contributionMapper.saveContribution(LocalDate.now(), form.user_id, form.solicitation_id);
        form.products.forEach(product -> {
            contributionProductMapper.saveContributionProduct(
                    contributionMapper.getLastContribution().id,
                    product.getProductId(),
                    product.getGivenAmount()
            );

            product.getProductId();

        });

        return contributionMapper.getLastContribution();

    }
}
