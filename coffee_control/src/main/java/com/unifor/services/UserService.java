package com.unifor.services;

import com.unifor.dtos.UserDto;
import com.unifor.forms.ContributionPostForm;
import com.unifor.forms.UserPostForm;
import com.unifor.models.User;

import java.util.List;

public interface UserService {

    List<UserDto> list();

    UserDto getSpecificUser(Long id);

    User register(UserPostForm form);

    void newContribution(Long id, ContributionPostForm form);

    void deleteUser(Long id);

}
