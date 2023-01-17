package com.unifor.services.impl;

import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.StorageDto;
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
    StorageMapper storageMapper;

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
    public ContributionDto saveContribution(ContributionPostForm form) {

//        System.out.println(form.solicitation_id);
//        System.out.println(form.user_id);
//        System.out.println(form.products);

        contributionMapper.saveContribution(LocalDate.now(), form.user_id, form.solicitation_id);
        for (int i = 0; i < form.products.size(); i++){

            StorageDto storageDto = storageMapper.getStorageByProductId(form.products.get(i).getProduct_id());

            storageMapper.updateAmountByProductId(
                    form.products.get(i).getProduct_id(),
                    (storageDto.getCurrentAmount() + form.products.get(i).getGivenAmount())
            );

            if(!contributionMapper.checkIfExistsInSolicitation(form.products.get(i).getProduct_id()))
                continue;

            contributionProductMapper.saveContributionProduct(
                    contributionMapper.getLastContribution().id,
                    form.products.get(i).getProduct_id(),
                    form.products.get(i).getGivenAmount()
            );
        }

        return contributionMapper.getLastContribution();

    }
}
