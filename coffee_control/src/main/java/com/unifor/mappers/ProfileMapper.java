package com.unifor.mappers;

import com.unifor.models.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfileMapper {
    @Select("SELECT * FROM profiles WHERE id = #{id}")
    Profile getProfile(Long id);
}
