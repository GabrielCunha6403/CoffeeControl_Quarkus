package com.unifor.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserPostForm {
    private String name;
    private String registration;
    private String password;
    private Long profile_id;

}
