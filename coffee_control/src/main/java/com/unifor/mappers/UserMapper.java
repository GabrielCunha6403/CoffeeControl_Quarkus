package com.unifor.mappers;

import com.unifor.dtos.*;
import com.unifor.models.Solicitation;
import com.unifor.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<UserDto> getUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserDto getUser(Long id);

    @Insert("INSERT INTO users (id, full_name, registration, pword, profile_id) VALUES (DEFAULT, #{name}, #{registration}, #{password}, #{profile_id})")
    Integer saveUser(@Param("name") String name, @Param("registration") String registration, @Param("password") String password, @Param("profile_id") Long profile_id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    Integer deleteUser(Long id);

    @Select("select s.* from solicitations s " +
            "join users u on s.assigned_user_id = u.id " +
            "where assigned_user_id = #{id}")
    List<SolicitationDto> getListOfSolicitations(Long id);

    @Select("select c.* from contributions c " +
            "join users u on c.user_id = u.id " +
            "where user_id = #{id}")
    List<ContributionDto> getListOfContributions(Long id);

    @Select("SELECT * FROM users WHERE id=(SELECT max(id) FROM users)")
    UserDto getLastUser();

    @Select("select * from users u "/* +
            "join contributions c on c.user_id = u.id " +
            "join solicitations s on s.assigned_user_id = u.id"*/)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "full_name"),
            @Result(property = "registration", column = "registration"),
            @Result(property = "password", column = "pword"),
            @Result(property = "profile_type", column = "profile_id", javaType = String.class, one = @One(select = "getNameOfProfile")),
            @Result(property = "contributions", column = "user_id", javaType = List.class, many = @Many(select = "getLightContributions")),
            @Result(property = "solicitations", column = "assigned_user_id", javaType = List.class, many = @Many(select = "getLightSolicitations"))
    })
    List<UserDetailDto> getUsersDetail();

    @Select("select profile_type from profiles where id = #{id}")
    String getNameOfProfile(Long id);

    @Select("select id, contribution_date, solicitation_id from contributions where user_id = #{user_id}")
    List<ContributionLightDto> getLightContributions(Long user_id);
    @Select("select id, solicitation_name, solicitation_date, solicitation_expiration from solicitations where assigned_user_id = #{id}")
    List<SolicitationLightDto> getLightSolicitations(Long id);

}

