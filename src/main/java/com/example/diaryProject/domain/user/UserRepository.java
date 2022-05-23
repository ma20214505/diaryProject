package com.example.diaryProject.domain.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users where name = #{name}")
    Optional<User> findByUsername(String username);

    @Insert("insert into users (name,password,authority) values(#{name},#{pw},#{authority})")
    void create(String name, String pw, String authority);

}
