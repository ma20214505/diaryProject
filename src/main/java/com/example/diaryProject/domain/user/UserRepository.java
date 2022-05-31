package com.example.diaryProject.domain.user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users where name = #{name}")
    Optional<User> findByUsername(String username);

    @Insert("insert into users (name,password,authority) values(#{name},#{pw},#{authority})")
    void create(String name, String pw, String authority);

    @Delete("delete from users where name = #{name} and password = #{password}")
    void delete(String name, String password);

}
