package com.example.diaryProject.domain.Admin;

import com.example.diaryProject.domain.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

@Mapper
public interface AdminRepository {

    @Select("select * from users")
    Collection<User> showUsers();

    @Delete("delete from users where id = #{id}")
    void delete(String[] id);

    @Select("select * from admin")
    Collection<Admin> showAdmin();

    //insert文を書く　ユーザーテーブル＆管理者テーブルに
    void create(String name, String pw);

    //delete文を書く　ユーザーテーブル＆管理者テーブル
    void deleteAdmin(String name, String pw);
}
