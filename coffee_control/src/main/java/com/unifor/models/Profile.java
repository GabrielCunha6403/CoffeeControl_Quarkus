package com.unifor.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Profile {
    private Integer id;
    private String name;
    private String description;
    private List<User> users;
}
