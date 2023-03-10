package com.unifor.models;


import com.unifor.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private Long id;
    private String name;
    private String description;
    private List<UserDto> users;
}
