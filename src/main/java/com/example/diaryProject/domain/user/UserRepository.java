package com.example.diaryProject.domain.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {


    @Insert("insert into users (name,password,authority) values(#{name},#{pw},#{authority})")
    void create(String name, String pw, String authority);
}
