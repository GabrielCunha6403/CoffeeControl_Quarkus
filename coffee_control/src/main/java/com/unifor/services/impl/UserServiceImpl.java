package com.unifor.services.impl;

import com.unifor.dtos.UserDetailDto;
import com.unifor.dtos.UserDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.UserPostForm;
import com.unifor.mappers.ProfileMapper;
import com.unifor.mappers.SolicitationMapper;
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

    public List<UserDto> list(){
//        List<UserDto> users = null;
//        System.out.print(userMapper.getUsers());
//        userMapper.getUsers().forEach(user -> users.add(new UserDto(user)));
        return userMapper.getUsers();
    }

    public UserDto getSpecificUser(Long id){
        return userMapper.getUser(id);
    }

    public List<UserDetailDto> getUsersDetail(){
        return userMapper.getUsersDetail();
    }

    public UserDto register(UserPostForm form){
        Profile profile = profileMapper.getProfile(form.getProfile_id());
        userMapper.saveUser(form.getName(), form.getRegistration(), form.getPassword(), profile.getId());
        return userMapper.getLastUser();
    }

    public void newContribution(Long id, ContributionPostForm form){
        //....
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}
