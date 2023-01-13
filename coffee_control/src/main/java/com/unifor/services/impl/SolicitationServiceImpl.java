package com.unifor.services.impl;

import com.unifor.dtos.SolicitationDto;
import com.unifor.forms.SolicitationPostForm;
import com.unifor.mappers.SolicitationMapper;
import com.unifor.mappers.SolicitationProductMapper;
import com.unifor.services.SolicitationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class SolicitationServiceImpl implements SolicitationService {

    @Inject
    SolicitationMapper solicitationMapper;

    @Inject
    SolicitationProductMapper solicitationProductMapper;

    @Override
    public List<SolicitationDto> list(){
        return solicitationMapper.getSolicitations();
    }

    @Override
    public SolicitationDto getSpecificSolicitation(Long id){
        return solicitationMapper.getSolicitation(id);
    }

    @Override
    public SolicitationDto saveSolicitation(Long id, SolicitationPostForm form){

         solicitationMapper.saveSolicitation(
                form.name,
                LocalDate.now(),
                true,
                id,
                LocalDate.now().plusDays(LocalDate.now().lengthOfMonth())
        );

        form.products.forEach(product -> {
            solicitationProductMapper.saveSolicitationProduct(
                    solicitationMapper.getLastSolicitation().id,
                    product.product_id,
                    product.required_amount);
        });

        return solicitationMapper.getLastSolicitation();
    }

    public void setEnable(){

    }

}
