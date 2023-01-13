package com.unifor.models;

import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.SolicitationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User {
    public Long id;
    public String name;
    public String registration;
    public String password;
    public List<SolicitationDto> solicitations;
    public List<ContributionDto> contributions;
    public Profile profile;

    public User(String name, String registration, String password, Profile profile) {
    }
}
