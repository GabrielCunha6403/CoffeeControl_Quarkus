package com.unifor.services.impl;

import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.ContributionProductForm;
import com.unifor.forms.UserPostForm;
import com.unifor.mappers.ProfileMapper;
import com.unifor.mappers.SolicitationMapper;
import com.unifor.mappers.UserMapper;
import com.unifor.models.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl {

    @Inject
    UserMapper userMapper;

    @Inject
    ProfileMapper profileMapper;

    @Inject
    SolicitationMapper solicitationMapper;

    public List<User> list(){
        return userMapper.getUsers();
    }

    public User getSpecificUser(Long id){
        return userMapper.getUser(id);
    }

    public User register(UserPostForm form){
        Profile profile = profileMapper.getProfile(form.getProfile_type());
        userMapper.saveUser(form.getName(), form.getRegistration(), form.getPassword(), profile.getId());
        return new User(form.getName(), form.getRegistration(), form.getPassword(), profile);
    }

    public void newContribution(Long id, ContributionPostForm form){
        Solicitation solicitation = solicitationMapper.getSolicitation(form.getSolicitationId());
        User user = userMapper.getUser(id);
        Contribution contribution = new Contribution(user, solicitation);
        for(ContributionProductForm current : form.getProducts()) {
            contribution.setProducts(contribution.getProducts() == null ? new ArrayList<ContributionProduct>() : contribution.getProducts());
            Integer productId=current.getProductId();
            Integer givenAmount=current.getGivenAmount();

        }

    }
}
