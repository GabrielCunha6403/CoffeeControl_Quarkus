package com.unifor.services;

import com.unifor.dtos.UserDetailDto;
import com.unifor.dtos.UserDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.UserPostForm;

import java.util.List;

public interface UserService {

    List<UserDto> list();

    UserDto getSpecificUser(Long id);

    UserDto register(UserPostForm form);

    void newContribution(Long id, ContributionPostForm form);

    void deleteUser(Long id);

    List<UserDetailDto> getUsersDetail();
}
