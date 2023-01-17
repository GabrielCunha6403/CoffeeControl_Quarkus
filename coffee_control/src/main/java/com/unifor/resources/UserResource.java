package com.unifor.resources;

import com.unifor.dtos.UserDetailDto;
import com.unifor.dtos.UserDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.UserPostForm;
import com.unifor.models.User;
import com.unifor.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<UserDto> list(){ return userService.list(); }

    @GET
    @Path("/{id}")
    public UserDto getSpecificUser(Long id){
        return userService.getSpecificUser(id);
    }

    @GET
    @Path("/detail")
    public List<UserDetailDto> getUsersDetail(){
        return userService.getUsersDetail();
    }

    @POST
    @Transactional
    public UserDto saveUser(UserPostForm form){
        return userService.register(form);
    }

    @POST
    @Transactional
    @Path("/{id}/addContribution")
    public void newContribution(Long id, ContributionPostForm form){
        userService.newContribution(id, form);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(Long id){ userService.deleteUser(id); }
}
