package com.unifor.models;

import java.util.List;


public class User {
    private Integer id;
    private String name;
    private String registration;
    private String password;
    private List<Solicitation> solicitations;
    private List<Contribution> contributions;
    private Profile profile;

    public User(String name, String registration, String password, Profile profile) {
        this.name = name;
        this.registration = registration;
        this.password = password;
        this.profile = profile;
    }
}
