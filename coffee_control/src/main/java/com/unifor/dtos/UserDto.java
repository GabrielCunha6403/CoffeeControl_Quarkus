package com.unifor.dtos;

import com.unifor.mappers.ProfileMapper;
import com.unifor.mappers.UserMapper;
import com.unifor.models.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDto {
    public Long id;
    public String name;
    public String registration;
    public String password;
    public Long profile_id;

    public UserDto(User u){
        this.id = u.id;
        this.name = u.name;
        this.registration = u.registration;
        this.password = u.password;
        this.profile_id = u.profile.getId();
    }

    public User convert(UserMapper mapper, ProfileMapper profileMapper){
        return new User(
                this.id,
                this.name,
                this.registration,
                this.password,
                mapper.getListOfSolicitations(this.id),
                mapper.getListOfContributions(this.id),
                profileMapper.getProfile(this.profile_id));
    }
}
