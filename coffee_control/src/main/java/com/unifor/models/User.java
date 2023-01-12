package com.unifor.models;

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
    public List<Solicitation> solicitations;
    public List<Contribution> contributions;
    public Profile profile;

    public User(String name, String registration, String password, Profile profile) {
        this.name = name;
        this.registration = registration;
        this.password = password;
        this.profile = profile;
    }
}
