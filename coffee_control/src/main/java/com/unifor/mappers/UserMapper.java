package com.unifor.mappers;

import com.unifor.dtos.ContributionDto;
import com.unifor.dtos.SolicitationDto;
import com.unifor.dtos.UserDto;
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

}

