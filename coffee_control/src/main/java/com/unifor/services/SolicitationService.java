package com.unifor.services;

import com.unifor.dtos.SolicitationDto;
import com.unifor.forms.SolicitationPostForm;

import java.util.List;

public interface SolicitationService {

    List<SolicitationDto> list();

    SolicitationDto getSpecificSolicitation(Long id);

    SolicitationDto saveSolicitation(SolicitationPostForm form);
}
