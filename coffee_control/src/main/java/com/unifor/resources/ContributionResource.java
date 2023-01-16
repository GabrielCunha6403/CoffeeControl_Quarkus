package com.unifor.resources;

import com.unifor.dtos.ContributionDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.services.ContributionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@ApplicationScoped
@Path("/contributions")
public class ContributionResource {

    @Inject
    ContributionService contributionService;

    @GET
    public List<ContributionDto> list(){
        return contributionService.list();
    }

    @GET
    @Path("/{id}")
    public ContributionDto getSpecificContribution(Long id){
        return contributionService.getSpecificContribution(id);
    }

    @POST
    public ContributionDto saveContribution(ContributionPostForm form) {
        return contributionService.saveContribution(form);
    }
}
