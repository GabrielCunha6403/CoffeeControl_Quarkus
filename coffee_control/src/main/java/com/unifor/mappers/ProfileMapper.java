package com.unifor.mappers;

import com.unifor.dtos.UserDto;
import com.unifor.models.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfileMapper {
    @Select("SELECT * FROM profiles WHERE id = #{id}")
    Profile getProfile(Long id);

    @Select("select * from users u " +
            "join profiles p on p.id = u.profile_id " +
            "where u.profile_id = #{id}")
    List<UserDto> getListOfUsers(Long id);
}
