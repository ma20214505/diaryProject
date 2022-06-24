package com.example.diaryProject.domain.user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.Optional;

@Mapper
public interface UserRepository {

    //ユーザー検索
    @Select("select * from users where name = #{name}")
    Optional<User> findByUsername(String username);

    //ユーザー作成
    @Insert("insert into users (name,password,authority) values(#{name},#{pw},#{authority})")
    void create(String name, String pw, String authority);

    //ユーザー削除
    @Delete("delete from users where name = #{name}")

    void delete(String name);

    @Select("select * from users where name = #{name} and password = #{password}")
    Optional<User> search(String name, String password);

    @Select("select password from users where name = #{name}")
    String getPassword(String name);
}
