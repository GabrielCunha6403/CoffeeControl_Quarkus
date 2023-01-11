package com.unifor.forms;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserPostForm {
    private String name;
    private String registration;
    private String password;
    private String profile_type="regular";

}