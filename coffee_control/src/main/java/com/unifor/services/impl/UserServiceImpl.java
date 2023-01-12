package com.unifor.services.impl;

import com.unifor.dtos.UserDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.UserPostForm;
import com.unifor.mappers.ProfileMapper;
import com.unifor.mappers.SolicitationMapper;
import com.unifor.mappers.SolicitationProductMapper;
import com.unifor.mappers.UserMapper;
import com.unifor.models.*;
import com.unifor.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserMapper userMapper;

    @Inject
    ProfileMapper profileMapper;

    @Inject
    SolicitationMapper solicitationMapper;

    @Inject
    SolicitationProductMapper solicitationProductMapper;

    public List<UserDto> list(){
//        List<UserDto> users = null;
//        System.out.print(userMapper.getUsers());
//        userMapper.getUsers().forEach(user -> users.add(new UserDto(user)));
        return userMapper.getUsers();
    }

    public UserDto getSpecificUser(Long id){
        return userMapper.getUser(id);
    }

    public User register(UserPostForm form){
        Profile profile = profileMapper.getProfile(form.getProfile_type());
        userMapper.saveUser(form.getName(), form.getRegistration(), form.getPassword(), profile.getId());
        return new User(form.getName(), form.getRegistration(), form.getPassword(), profile);
    }

    public void newContribution(Long id, ContributionPostForm form){
        Solicitation solicitation = solicitationMapper.getSolicitation(form.getSolicitationId());
//        User user = userMapper.getUser(id);
//        Contribution contribution = new Contribution(user, solicitation);
//        for(ContributionProductForm current : form.getProducts()) {
//            contribution.setProducts(contribution.getProducts() == null ? new ArrayList<ContributionProduct>() : contribution.getProducts());
//            Long productId= Long.valueOf(current.getProductId());
//            Integer givenAmount=current.getGivenAmount();
//            if(!solicitationProductMapper.checkIfProductExistsInSolicitation(solicitation.getId(), productId)){
//                continue;
//            }
//        }

    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}
