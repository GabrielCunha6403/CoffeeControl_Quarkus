package com.unifor.mappers;

import com.unifor.dtos.UserDto;
import com.unifor.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
//    @Results(value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "full_name"),
//            @Result(property = "registration", column = "registration"),
//            @Result(property = "password", column = "pword"),
//            @Result(property = "profile_id", column = "profile_id")
//    })
    List<UserDto> getUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserDto getUser(Long id);

    @Insert("INSERT INTO users (id, full_name, registration, pword, profile_id) VALUES (DEFAULT, #{name}, #{registration}, #{password}, #{profile_id})")
    Integer saveUser(@Param("name") String name, @Param("registration") String registration, @Param("password") String password, @Param("profile_id") Long profile_id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    Integer deleteUser(Long id);
}

