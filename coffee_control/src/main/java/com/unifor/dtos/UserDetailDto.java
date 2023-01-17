package com.unifor.dtos;

import java.util.List;

public class UserDetailDto {
    public Long id;
    public String name;
    public String registration;
    public String password;
    public String profile_type;
    public List<ContributionLightDto> contributions;
    public List<SolicitationLightDto> solicitations;
}
