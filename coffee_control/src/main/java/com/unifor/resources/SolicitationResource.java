package com.unifor.resources;

import com.unifor.dtos.SolicitationDto;
import com.unifor.forms.SolicitationPostForm;
import com.unifor.services.SolicitationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@ApplicationScoped
@Path("/solicitations")
public class SolicitationResource {

    @Inject
    SolicitationService solicitationService;

    @GET
    public List<SolicitationDto> list(){ return solicitationService.list(); }

    @GET
    @Path("/{id}")
    public SolicitationDto getSpecificSolicitation(Long id){
        return solicitationService.getSpecificSolicitation(id);
    }

    @POST
    public SolicitationDto saveSolicitation(SolicitationPostForm form){
        return solicitationService.saveSolicitation(form);
    }

}
