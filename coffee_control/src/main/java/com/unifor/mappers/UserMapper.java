package com.unifor.mappers;

import com.unifor.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUser(Long id);

    @Insert("INSERT INTO users (id, full_name, registration, pword, profile_id) VALUES (DEFAULT, #{name}, #{registration}, #{password}, #{profile_id})")
    Integer saveUser(@Param("name") String name, @Param("registration") String registration, @Param("password") String password, @Param("profile_id") Integer profile_id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    Integer deleteUser(Long id);
}

